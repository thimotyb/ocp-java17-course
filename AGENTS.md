# AGENTS.md — Operating Playbook for Agents

## Goal
Ensure every chapter of the OCP Java 17 course is created or updated with a consistent instructional structure (summary, examples, exercises, quizzes, tests) starting from the source PDF.

> **Language policy**: all written material (docs, code comments, commit messages, quiz wording, etc.) must be produced in English. Convert any legacy Italian content while you work.

## Workflow for a new chapter
1. **Environment check**
   - Verify required tools (`python3`, `PyPDF2`, Maven, Java 17) are available.
   - Initialise SDKMAN and switch to Java 17: `source ~/.sdkman/bin/sdkman-init.sh && sdk use java 17.0.14-tem`. Install it first if needed with `sdk install java 17.0.14-tem`.
   - If Python libraries are missing, install with `python3 -m pip install --user PyPDF2`.
2. **PDF ingestion**
   - Locate the chapter PDF and extract the full text into a temporary file (for example `/tmp/chXX_<name>.txt`) using `PyPDF2.PdfReader`.
   - Keep the dump until the summary, exercises, and quizzes are drafted.
3. **Content analysis**
   - Scan the text for sections on tooling, key concepts, code snippets, tables, and end-of-chapter quizzes.
   - Note items that will feed learning objectives, narrative summary, hands-on exercises, and exam-style questions.
4. **Update chapter README** (`chapters/chXX-*/README.md`)
   - Follow the standard structure: Learning Objectives → Chapter Summary with sub-sections → Practical Exercises → Exam Prep (questions + answers) → Next Steps.
   - Include a short “Run the Examples” subsection that explains how to execute the chapter’s demos (for example, `java -cp …` or the relevant Maven test command).
   - Keep language concise; use bullet lists and code fences when helpful.
5. **Plan examples and tests**
   - Define source paths inside the Maven module (`src/main/java/...`, `src/test/java/...`).
   - Examples must reflect the chapter content; base them on code from the book where possible.
   - Design JUnit 5 tests with deterministic assertions.
6. **Implement code**
   - Create Java files with minimal, purposeful comments.
   - Use coherent package names (`chXX.*`) and stick to Java 17-compatible language features.
7. **Write tests**
   - Place tests under `src/test/java/...` and annotate with `@Test` from JUnit Jupiter.
   - Avoid flaky scenarios (control randomness with seeds or stubs).
8. **Verify**
   - Run `source ~/.sdkman/bin/sdkman-init.sh && sdk use java 17.0.14-tem && mvn -pl chapters/chXX-* test`.
   - Fix failures and rerun until green.
9. **Clean up and report**
   - Remove temporary files.
   - Use `git status` to confirm tracked changes.
   - Summarise modifications and suggest next actions (for example, additional exercises or commits).

## Consistency notes
- Every chapter must be reproducible by following the steps above, regardless of the agent or session.
- Always reference chapter concepts (tooling, code, quizzes) in the README.
- Make sure each chapter README explains how to run the provided examples or associated tests.
- Do not overwrite user changes that are out of scope; coordinate when conflicts arise.
- Maintain English across documents, code comments, test names, and quiz content.

## Quick checklist before finishing
- [ ] README updated with the standard structure in English, including “Run the Examples”.
- [ ] Example code present under `src/main/java`.
- [ ] JUnit tests present under `src/test/java` and passing.
- [ ] Build/test output captured in the final handover message.
