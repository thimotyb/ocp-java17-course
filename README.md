# OCP Java 17 Course

A curated set of chapter modules, examples, and exercises to prepare for the Oracle Certified Professional Java SE 17 Developer (1Z0-829) exam. Each chapter mirrors the structure of the official study guide and contains:

- A README with learning objectives, summaries, exercises, and exam-style quizzes.
- Sample code under `src/main/java`.
- JUnit 5 tests under `src/test/java`.

## Repository Layout
```
ocp-java17-course/
├─ README.md                     # You are here
├─ AGENTS.md                     # Agent playbook and workflow
├─ pom.xml                       # Parent Maven build
├─ chapters/                     # One Maven module per chapter
│  └─ ch01-language-basics/
│     ├─ pom.xml
│     ├─ README.md               # Chapter summary, exercises, quiz
│     └─ src/
└─ scripts/
   └─ new-chapter.sh             # Helper to scaffold a new module
```

## Prerequisites
- **Java 17** (Temurin via SDKMAN is recommended)
- **Apache Maven 3.8+**
- Optional: Git for version control

### Install Java 17 with SDKMAN
1. Install SDKMAN if it is not already present:
   ```bash
   curl -s "https://get.sdkman.io" | bash
   source "$HOME/.sdkman/bin/sdkman-init.sh"
   ```
2. Install Temurin 17 and make it active for the current shell:
   ```bash
   sdk install java 17.0.14-tem
   sdk use java 17.0.14-tem
   ```
3. Verify the version:
   ```bash
   java -version
   # openjdk version "17.0.14" ...
   ```

## Build and Test
Run all chapters:
```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem
mvn clean verify
```

Run a single chapter:
```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem
mvn -pl chapters/ch01-language-basics test
```

## Run the Examples
Compiled classes live in `target/classes` inside each module. For chapter 1 you can launch the snippets straight from the book:
```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem
mvn -pl chapters/ch01-language-basics compile
java -cp chapters/ch01-language-basics/target/classes ch01.examples.Zoo
java -cp chapters/ch01-language-basics/target/classes ch01.examples.ZooArguments Bronx Zoo
```
Other listings without a `main` method (for example `Animal`, `Mouse`, `Egg`) are exercised through the accompanying `ch01.examples.*Test` classes:
```bash
mvn -pl chapters/ch01-language-basics -Dtest='ch01.examples.*Test' test
```
Refer to each chapter README for additional entry points or usage notes.

## Create a New Chapter
Use the provided script and then add the module to the parent `pom.xml`:
```bash
./scripts/new-chapter.sh ch02-oop-and-sealed
```
Populate the generated README, source, and test folders following the format in `AGENTS.md`.

## Contributing
1. Work on a feature branch.
2. Ensure all tests pass (`mvn -pl chapters/<module> test`).
3. Keep documentation and examples in English.
4. Submit a pull request describing the changes and the chapter they belong to.
