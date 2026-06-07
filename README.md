# sapp-api-contracts

Protobuf contract definitions for all Sapp backend services.

## Structure

```
proto/
  sapp/
    common/v1/common.proto          — shared PageInfo / PageCursor types
    messaging/v1/messaging_service.proto  — MessagingService (chat, sync, history)
    media/v1/media_service.proto    — MediaService (upload, processing, retrieval)
```

## Usage

This repo is consumed as a git submodule in `sapp-mobile-android`:

```
third_party/sapp-api-contracts/
```

The Android Gradle build adds `proto/` as an additional protobuf source directory
and generates Kotlin + Java stubs via the `com.google.protobuf` plugin.

## Development

Install the shared git hooks once per clone:

```
git config core.hooksPath .githooks
```

The `pre-commit` hook mirrors CI (`buf format`, `buf lint`, namespace guardrail)
so proto issues are caught locally. It requires [`buf`](https://buf.build/docs/installation)
in `PATH`. Do not align fields/comments by hand — run `buf format -w` instead.

## Versioning

Breaking changes bump the package version suffix (`v1` → `v2`).
Additive changes (new fields, new RPCs) are backward-compatible.
