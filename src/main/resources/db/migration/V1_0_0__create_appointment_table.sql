CREATE TABLE appointments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    date_time TIMESTAMP WITH TIME ZONE NOT NULL,
    duration INTEGER NOT NULL CHECK (duration > 0),
    location VARCHAR(500) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'CREATED',

    applicant_id UUID NOT NULL,
    applicant_name VARCHAR(255) NOT NULL,

    participant_id UUID NOT NULL,
    participant_name VARCHAR(255) NOT NULL,

    observations TEXT,

    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    deleted_at TIMESTAMP WITH TIME ZONE,

    CONSTRAINT chk_future_date_time CHECK (date_time > NOW()),
    CONSTRAINT chk_status_valid CHECK (status IN ('CREATED', 'CONFIRMED', 'CANCELLED', 'FINISHED', 'IN_PROGRESS'))
);

CREATE INDEX idx_appointments_date_time ON appointments(date_time) WHERE deleted_at IS NULL;
CREATE INDEX idx_appointments_status ON appointments(status) WHERE deleted_at IS NULL;
CREATE INDEX idx_appointments_applicant ON appointments(applicant_id) WHERE deleted_at IS NULL;
CREATE INDEX idx_appointments_participant ON appointments(participant_id) WHERE deleted_at IS NULL;

CREATE INDEX idx_appointments_deleted ON appointments(deleted_at);

COMMENT ON TABLE appointments IS 'Generic appointments table';
COMMENT ON COLUMN appointments.applicant_id IS 'UUID of the applicant (future: FK for users)';
COMMENT ON COLUMN appointments.applicant_name IS 'TEMPORARY - Name of the applicant until keycloak is not integrated';
COMMENT ON COLUMN appointments.participant_id IS 'UUID do participant (future: FK for professionals)';
COMMENT ON COLUMN appointments.participant_name IS 'TEMPORARY - Name of the participant until keycloak is not integrated';
COMMENT ON COLUMN appointments.deleted_at IS 'Soft delete - when not null, the appointment was deleted';