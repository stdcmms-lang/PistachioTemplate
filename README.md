# Pistachio Template Suite

## What is it?

Pistachio is a suite of Skills, SubAgents, and Examples to facilitate cross-platform mobile development. It is intended to help non-technical users without mobile development experience quickly build an app for both Android and iOS.

## Features

- **One-shot setup:** In your vibe coding clients (Claude Code or Open Code), use `/check-local-project` to install all dependencies and tools for mobile development (Android SDK, iOS emulator, etc.).

- **Save tokens by sharing code:** This suite is a thin wrapper on top of the official Kotlin Multiplatform template, which allows you to share code between iOS and Android apps.

- **Flexibility:** Unlike other cross-platform frameworks like React Native and Flutter, you have full flexibility to choose which tech stack to use for your app. You can build with native iOS SwiftUI or Android Jetpack Compose components.

- **Asset discovery:** Pistachio MCP server provides tools to search for fonts and image assets.

- **Autonomy:** Pistachio MCP server gives the AI model the ability to "see" interactions on your app, closing the feedback loop for autonomous development.

## How to use it

1. Add Pistachio to your MCP configuration.

   **For `.mcp.json`:**

   ```json
   {
     "mcpServers": {
       "pistachio": {
         "type": "http",
         "url": "https://mcp.pistachio.technology/message",
         "transport": {
           "type": "http"
         }
       }
     }
   }
   ```

   **For `opencode.json`:**

   ```json
   {
     "$schema": "https://opencode.ai/config.json",
     "mcp": {
       "pistachio": {
         "type": "remote",
         "url": "https://mcp.pistachio.technology/message",
         "enabled": true
       }
     }
   }
   ```

2. Run `/check-local-project ProjectName com.project.package.name` to set up your project.

3. Restart your client to reload the newly added skills.

4. Use `/image-to-app` to create an entire app from mobile screenshots.
