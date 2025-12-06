# Contributing Guide

Thank you for considering contributing to Chronos! This document provides guidelines and instructions for contributing.

## Table of Contents

- [Code of Conduct](#code-of-conduct)

- [Getting Started](#getting-started)

- [Development Workflow](#development-workflow)

- [Pull Request Process](#pull-request-process)

- [Coding Standards](#coding-standards)

- [Testing](#testing)

- [Documentation](#documentation)

- [Reporting Bugs](#reporting-bugs)

- [Feature Requests](#feature-requests)

- [Community](#community)

- [First time contributors](#quick-start-for-first-time-contributors)

## Code of Conduct

Please read and follow our [Code of Conduct](./CODE_OF_CONDUCT.md). We are committed to providing a welcoming and inclusive environment for all contributors.

## Getting started

### Prerequisites

- List required software / tools:

  - Java JDK 21+

  - Maven 3.9+

  - Docker 29+

  - Git 2.34+

### Setting Up Development Environment

1. **Fork the repository**

    ```bash
    # Click the 'Fork' button on GitHub
    # Clone your fork locally
    git clone https://github.com/<your-username>/<project-name>.git
    cd <project-name>
    ```

2. **Set up upstream remote**

    ```bash
    git remote add upstream https://github.com/Paulo-Possatto/chronos.git
    ```

3. **Install dependencies**

    ```bash
    mvn clean install
    ```

4. **Verify setup**

    ```bash
    mvn test
    ```

### Development Workflow

#### Branch Strategy

```text
main                # Production-ready code (only with PRs)
│
└── feat/*          # Feature branches
└── fix/*           # Bug fix branches
└── hotfix/*        # Critical fixes
└── release/*       # Release preparation
└── chore/*         # Non-code branches
```

#### Branch Naming Convention

- **Features**: `feat/description` or `feat/issue-number-description`

  - **Example**: `feature/add-user-authentication` or `feature/123-add-login`

- **Bug fixes**: `fix/description` or `fix/issue-number-description`

  - **Example**: `fix/fix-null-pointer-exception`

- **Hotfixes**: `hotfix/description`

  - **Example**: `hotfix/security-patch`

- **Documentation, dependencies or other non-code changes**: `chore/description`

  - **Example**: `chore/update-api-documentation`

For more information about branch naming conventions, please check the [official documentation](https://conventional-branch.github.io/)

#### Commit Guidelines

We follow [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/):

```text
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

**Types**:

- `feat`: New feature

- `fix`: Bug fix

- `docs`: Documentation changes

- `style`: Code style changes (formatting, etc.)

- `refactor`: Code refactoring

- `test`: Adding or updating tests

- `chore`: Maintenance tasks, dependencies

**Examples**:

```text
feat(auth): add OAuth2 support
fix(api): resolve null pointer in user service
docs: update installation guide
```

### Pull Request Process

1. **Create an Issue First** (for non-trivial changes)

    - Check for existing issues

    - Describe the problem or feature

    - Wait for approval before starting work

2. **Create a Pull Request**

    - Create a [Pull Request](https://github.com/Paulo-Possatto/chronos/pulls) and use our template

    - Reference the related issue (#123)

    - Keep changes focused and atomic

3. **Pull Request Requirements**

    - All tests must pass

    - Code follows style guidelines

    - Documentation updated if needed

    - No breaking changes without discussion

4. **Review Process**

    - At least one maintainer must approve

    - Address review comments promptly

    - Keep PR updated with target branch

### PR Checklist

- Tests added / updated

- Documentation updated

- Code follows style guidelines

- Self-reviewed my own code

- All checks pass

- No breaking changes (or documented)

### Coding Standards

#### Java Style Guide

```java
// Class naming
public class UserService { }

// Method naming
public void calculateTotalPrice() { }

// Variables
private final String userName;
private static final int MAX_RETRIES = 3;

// Annotations
@Override
@Nullable
@Test
```

#### Code Quality

- Use meaningful variable/method names

- Keep methods small and focused (< 30 lines)

- Avoid deep nesting (> 3 levels)

- Add comments for complex logic

- Remove unused code and imports

SonarQube is used to validate code quality during Pipeline execution

#### Security Considerations

- **Never** commit secrets or credentials, use .env file if nedded

- Validate all inputs

- Use prepared statements for SQL if your changes does not use hibernate

- Follow principle of least privilege

### Testing

#### Test Structure

```text
src/test/java/
├── com/chronos/test/unit/         # Unit tests
├── com/chronos/test/integration/  # Integration tests
└── com/chronos/test/contract/     # Contrat (Pact) tests
```

#### Running Tests

```bash
# Unit tests only
mvn test

# All tests
mvn verify

# Specific test class
mvn test -Dtest=UserServiceTest

# With coverage report
mvn test jacoco:report
```

#### Test Requirements

- Unit tests for new features

- Integration tests for critical paths

- Maintain ≥ 80% code coverage

- Tests must be independent

- Mock injected dependencies

### Documentation

#### What to Document

- Public APIs: Classes, methods, parameters

- Configuration: Environment variables, properties

- Architecture: High-level design decisions

- Examples: Usage examples in `/examples/`

- Changelog: Keep `CHANGELOG.md` updated

#### Documentation Structure

```text
docs/
├── api/              # API documentation
├── guides/           # How-to guides
├── architecture/     # Design documents
└── examples/         # Code examples
```

### Reporting Bugs

#### Before Submitting

1. Check existing issues

2. Update to latest version

3. Check documentation

### Feature Requests

1. **Check existing features** and issues

2. **Describe the problem** you're solving

3. **Propose a solution** with examples

4. **Discuss implementation** with maintainers

### Community

#### Communication Channels

- **Issues**: [GitHub Issues](https://github.com/Paulo-Possatto/chronos/issues) for bugs and features

- **Discussions**: [GitHub Discussions](https://github.com/Paulo-Possatto/chronos/discussions) for Q&A, ideas, polls, etc.

- **Chat**: _Not available yet_, perhaps a dicord channel in the future...

### Getting Help

1. Check documentation first

2. Search [existing issues](https://github.com/Paulo-Possatto/chronos/issues)

3. Ask in [Discussions](https://github.com/Paulo-Possatto/chronos/discussions)

4. Be patient and respectful

### Recognition

Contributors are recognized in:

- Release notes

- Contributors.md file

- Project documentation

- [README.md](/README.md) file

### License

By contributing, you agree that your contributions will be licensed under the project's [LICENSE](/README.md).

---

### Quick Start for First-Time Contributors

Looking for a good first issue? Check issues tagged:

- good-first-issue

- help-wanted

- beginner-friendly

#### Simple Contribution Flow

1. Find a small issue

2. Comment "I'd like to work on this"

3. Fork and create branch

4. Make changes and test

5. Submit PR with description (follow the template)

Thank you for contributing! Your help makes this project better for everyone.

---

##### _This document was inspired by contribution guidelines from awesome open-source projects_
