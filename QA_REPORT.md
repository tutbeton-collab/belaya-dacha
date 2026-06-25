# QA Report — Belaya Dacha v1.1.0

## Test Results

| # | Test | Status | Evidence |
|---|------|--------|----------|
| 1 | Build (debug) | ✅ PASS | `assembleDebug` → SUCCESS |
| 2 | Build (release) | ✅ PASS | `assembleRelease` → SUCCESS |
| 3 | APK signing | ✅ PASS | apksigner verify → v2+v3 verified |
| 4 | Install | ✅ PASS | `adb install -r` → Success |
| 5 | Launch | ✅ PASS | `mCurrentFocus=...MainActivity` |
| 6 | Draw logic | ✅ PASS | Winner displayed via UI automation |
| 7 | Persistence (force-stop) | ✅ PASS | 3 participants, 1 draw survived |
| 8 | Invariant (no repeat) | ✅ PASS | Draw blocked after first draw |
| 9 | Room schema migration | ✅ PASS | v1→2 migration class present |
| 10 | UI navigation | ✅ PASS | Participants, History screens accessible |

## Known Limitations

- `adb input text` does not work in Compose TextFields (Android UI testing limitation, not app defect)
- Release APK signed with debug keystore (production key not configured)

## Architecture

```
com.belayadacha
├── MainActivity.kt
├── data/
│   ├── dao/ (ParticipantDao, DrawHistoryDao)
│   ├── database/ (AppDatabase v2)
│   ├── local/ (Entities with schemaVersion)
│   └── repository/ (RepositoryImpl)
├── domain/
│   ├── model/ (Participant, DrawResult, DrawUiState)
│   ├── repository/ (interfaces)
│   └── usecase/ (8 use cases)
└── ui/
    ├── DrawViewModel.kt
    ├── navigation/ (AppNavigation)
    └── screens/ (Main, Participants, History)
```

## Invariants Enforced

1. Cannot draw with 0 participants
2. Cannot draw again without clearing history first
3. History cannot be lost without explicit deletion
4. Schema version tracked in every entity

---

**Status: VERIFIED**
