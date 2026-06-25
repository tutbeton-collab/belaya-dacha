# REOPEN PROTOCOL

## Overview
Projects in FINALIZED or ARCHIVED state require explicit reopening before any modifications.

## Protocol Steps

### Step 1: User Command
User must send: `TASK_REOPENED <project-name>`

### Step 2: State Transition
```
PROJECT_STATE: FINALIZED → REOPENED
```

### Step 3: Audit Log Entry
```
{"ts":"<timestamp>","event":"TASK_REOPENED","project":"<name>","reason":"<user reason>"}
```

### Step 4: New Cycle Begins
```
PROJECT_STATE: REOPENED → IN_PROGRESS (when spec provided)
```

## Enforcement

### Before ANY git operation or file edit:
1. Read LOCK.md
2. If PROJECT_STATE = FINALIZED/ARCHIVED:
   - DENY: file edits, commits, pushes, releases
   - ALLOW: read-only audit, report generation
   - RESPOND: "PROJECT LOCKED. Required: TASK_REOPENED."
3. If PROJECT_STATE = REOPENED:
   - Allow operations normally
   - Log transition to IN_PROGRESS when spec received

### Git Hook:
- .githooks/pre-commit checks LOCK.md
- Blocks commits to FINALIZED/ARCHIVED projects
- Allows commits only with TASK_REOPENED in message or valid state transition

## What This Blocks:
- ✅ Accidental commits by agent
- ✅ File modifications by agent (behavioral)
- ✅ New releases (gh release create on locked project)

## What This Does NOT Block:
- ❌ Direct file system access by other processes
- ❌ Git operations with --no-verify
- ❌ User actions through other terminals/sessions
- ❌ Automated system scripts

## Honesty Declaration:
This protocol adds friction to prevent accidental changes.
It is not an absolute technical barrier.
The primary enforcement mechanism is agent self-discipline, reinforced by git hooks.
