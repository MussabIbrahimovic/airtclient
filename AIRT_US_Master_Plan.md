# AIRT.US — Premium Client Design & Go-to-Market Master Document

## 0) Legal/Ethics Positioning (for product risk control)
AIRT.US should be presented internally as an **educational modding/R&D project** with strict abuse disclaimers, EULA acceptance, and regional compliance controls. Public materials should avoid direct claims of bypassing protected systems and instead frame features as “advanced client customization.”

---

## 1) Detailed Product Documentation

### 1.1 Product Vision
**AIRT.US** is a premium, performance-focused, cross-version Minecraft utility client delivering a unified experience from legacy PvP (1.8.9) through modern versions (1.21.1), with high customizability, scripting, and polished UX.

### 1.2 Positioning
- **Brand**: Private, polished, elite, actively maintained.
- **Audience segments**:
  - Legacy PvP users (1.8.9)
  - Crystal/utility users (1.12.2+)
  - Modern-version users requiring compatibility + clean UI
- **Core value props**:
  - One client across many versions
  - Deep module stack + advanced profiles
  - Premium UI and automation ecosystem

### 1.3 Architecture Blueprint

#### Runtime Layers
1. **Bootstrap/Loader Layer**
   - Injects Mixins at startup
   - Performs signature checks and module registry validation
2. **Compatibility Layer**
   - Version abstraction interfaces (`IPlayerAdapter`, `IWorldAdapter`, `INetworkAdapter`)
   - Packet wrappers per protocol family
3. **Core Engine Layer**
   - Event bus (priority + cancellable + staged PRE/POST)
   - Module lifecycle manager
   - Settings and profile manager
4. **Feature Layer**
   - Combat, Movement, Player, Render, World, Misc, Automation categories
5. **Presentation Layer**
   - ClickGUI/HUD/Theme system with animation engine
6. **Security/Distribution Layer**
   - License, updater, telemetry (opt-in), tamper checks

#### Suggested Package Layout (Java 21)
```text
us.airt.client
  ├─ bootstrap
  ├─ mixin
  ├─ api
  │   ├─ event
  │   ├─ module
  │   ├─ setting
  │   └─ script
  ├─ core
  │   ├─ eventbus
  │   ├─ module
  │   ├─ config
  │   ├─ profile
  │   └─ version
  ├─ feature
  │   ├─ combat
  │   ├─ movement
  │   ├─ player
  │   ├─ render
  │   ├─ world
  │   └─ misc
  ├─ ui
  │   ├─ clickgui
  │   ├─ hud
  │   ├─ theme
  │   └─ anim
  ├─ security
  ├─ scripting
  └─ update
```

#### Event System Spec
- Event priorities: `HIGHEST > HIGH > NORMAL > LOW > LOWEST`
- Event stages: `PRE`, `POST`
- Cancellable events for packet send/receive, movement, input, render overlays.
- Tick domains:
  - `ClientTickEvent`
  - `WorldTickEvent`
  - `Render3DEvent`
  - `Render2DEvent`
  - `PacketEvent`
  - `AttackEvent`
  - `MoveEvent`

#### Configuration System
- Dual format support: JSON (default), YAML (optional import/export)
- Structure:
  - `configs/global/*.json`
  - `configs/profiles/<server>/<profile>.json`
  - `configs/ui/theme.json`
  - `scripts/*.js` and `scripts/*.lua`
- Validation:
  - schema versioning
  - migration pipeline (`v1 -> v2 -> v3`)

#### Scripting Runtime
- JavaScript engine: GraalJS (Java 21-friendly)
- Lua engine: LuaJ/JNLua bridge
- API domains:
  - `client`, `module`, `player`, `world`, `render`, `network`, `chat`, `timer`
- Security sandbox tiers:
  - Trusted scripts (full API)
  - Community scripts (restricted filesystem/network)

### 1.4 Version Support Matrix
| Version | Priority Use Case | Notes |
|---|---|---|
| 1.8.9 | Competitive legacy PvP | Lowest latency paths, classic combat timing |
| 1.12.2 | Crystal/utility ecosystems | Legacy packet quirks + utility modules |
| 1.16.5 | Modern combat transition | Broad server support baseline |
| 1.18.2 | Performance + caves update era | Rendering optimizations required |
| 1.19.4 | Newer combat/utility | Signed chat era handling |
| 1.20.4 | Current mainstream | Stability-first profile presets |
| 1.21.1 | Latest compatibility | Fast patch cadence after MC updates |

### 1.5 Module Inventory Strategy (200+)
Use the provided feature list as complete capability scope, grouped by:
- Combat
- Movement
- Player
- Render
- World
- Exploit/Misc
- Automation/Scripting

Each module should implement:
- `onEnable/onDisable`
- deterministic setting model
- profile tags (`legit`, `rage`, `utility`, `anarchy`, `farm`)
- compatibility flags per version

---

## 2) Marketing Materials

### 2.1 Brand Messaging
**Tagline**: *AIRT.US — One client. Every era. Total control.*

**Hero Copy**:
> Dominate legacy and modern Minecraft with a premium cross-version client built for performance, flexibility, and style.

### 2.2 Feature Marketing Blocks
- **Cross-Version Mastery**: 1.8.9 to 1.21.1 in one ecosystem.
- **Deep Customization**: 200+ modules, script API, and profile automation.
- **Premium Experience**: Dark purple/black UI, smooth animations, modern workflow.
- **Private Community**: Limited keys, private Discord, direct feedback loop.

### 2.3 Sales Angle
- Scarcity-based onboarding (limited key waves)
- Lifetime value proposition ($25–30 one-time)
- High-touch support and frequent updates

---

## 3) Module Organization System

### 3.1 Category Taxonomy
1. **Combat** (Killaura, AutoClicker, Velocity, Reach, Criticals, AutoArmor, Totem, Shield, BowAimbot, AntiBot)
2. **Movement** (Flight, Speed, LongJump, Step, NoFall, Jesus, Scaffold, Spider, NoSlow, Sprint)
3. **Player** (AutoEat, AutoTool, Blink, Freecam, InventoryManager, ChestStealer)
4. **Render** (ESP, Tracers, Xray, Chams, Animations, HUD, Weather)
5. **World** (Nuker, AutoFarm, AutoFish, CrystalBreaker, ChestAura, Vehicle control)
6. **Misc/Exploit** (Bypass tools, utility packet modules, automation helpers)
7. **Scripts** (user-defined custom modules)

### 3.2 Registry Model
- `ModuleDescriptor`: id, displayName, category, versionSupport, riskLevel
- `SettingDescriptor`: key, type, default, constraints, visibility predicate
- Dynamic setting visibility for cleaner GUI

### 3.3 Risk Labels (UI badges)
- `SAFE` (visual/QoL)
- `MEDIUM` (moderate detectability)
- `HIGH` (aggressive behavior)

---

## 4) GUI/UI Concept (Dark Purple/Black)

### 4.1 Visual Language
- Primary background: `#0B0A12`
- Secondary surface: `#151225`
- Accent purple: `#8B5CF6`
- Accent hover: `#A78BFA`
- Success: `#22C55E`, Warning: `#F59E0B`, Danger: `#EF4444`

### 4.2 Layout
- **Top bar**: profile selector, server detector, search, panic key state
- **Left rail**: categories + icons
- **Center panel**: module cards with toggles and quick presets
- **Right panel**: contextual settings with sliders, enums, keybind capture
- **Bottom strip**: performance stats (FPS, ping, memory, TPS)

### 4.3 Animations
- Easing: cubic-bezier smooth transitions (120–240ms)
- Toggle micro-interactions with glow pulse
- Expand/collapse spring motion for module settings

### 4.4 HUD System
- Drag-drop editor grid
- Snap guides + percentage-based anchoring
- Presets: Minimal, Competitive, Streamer, Debug

---

## 5) Configuration Templates (Popular Server Styles)

> These are **high-level playstyle presets** (not server-specific bypass instructions).

### 5.1 `template_legit_pvp.json`
- conservative ranges/timings
- minimal visuals
- safe movement assists

### 5.2 `template_aggressive_pvp.json`
- high responsiveness
- advanced targeting priorities
- robust combat HUD + alerts

### 5.3 `template_anarchy_utility.json`
- world/render utility emphasis
- automation + inventory throughput
- survival risk monitors

### 5.4 `template_survival_qol.json`
- farming/mining automation set
- storage and route helpers
- non-combat UI overlays

---

## 6) JavaScript Engine Example Scripts

### 6.1 Auto GG Script (chat event)
```javascript
registerEvent("KillEvent", (e) => {
  if (!e || !e.targetName) return;
  client.chat(`gg ${e.targetName}`);
});
```

### 6.2 Health Warning Overlay
```javascript
registerEvent("Render2DEvent", () => {
  const hp = player.getHealth();
  if (hp <= 8) {
    render.text("LOW HP", 20, 40, 0xEF4444FF, 1.4);
  }
});
```

### 6.3 Auto Potion Helper (safe logic)
```javascript
registerEvent("ClientTickEvent", () => {
  if (player.getHealth() < 10 && player.hasItem("splash_healing")) {
    module.call("AutoPotion", "throwSelfHeal");
  }
});
```

---

## 7) Website Layout (AIRT.US)

### 7.1 Sitemap
- Home
- Features
- Versions
- Pricing
- Changelog
- Docs
- Community (Discord)
- Account Dashboard

### 7.2 Home Page Structure
1. Hero + CTA (“Buy Lifetime”)
2. Supported versions marquee
3. Feature pillars (performance, customization, UX)
4. UI screenshot carousel
5. Testimonials/social proof
6. Pricing card
7. FAQ + policy links

### 7.3 Dashboard
- License status
- Device/HWID panel
- Downloads (stable/beta)
- Config cloud sync management
- Support ticket entry

---

## 8) Discord Server Structure

### 8.1 Category Layout
- **START HERE**
  - `#welcome`
  - `#rules`
  - `#announcements`
- **CUSTOMER HUB**
  - `#download-help`
  - `#config-sharing`
  - `#scripts`
  - `#troubleshooting`
- **COMPETITIVE**
  - `#pvp-discussion`
  - `#clips-media`
- **DEVELOPMENT**
  - `#changelog`
  - `#beta-feedback`
  - `#bug-reports` (form)
  - `#feature-requests`
- **PRIVATE STAFF**
  - `#mod-chat`
  - `#incident-log`
  - `#release-checklist`

### 8.2 Roles
- Owner
- Lead Dev
- Dev
- Moderator
- Support
- Lifetime Customer
- Beta Tester
- Verified

---

## 9) Pricing / Tier Structure

### 9.1 Core Offer
- **Lifetime License**: **$29.99** (target range $25–30)
- Limited key waves (e.g., 200 keys per drop)
- Includes private Discord + standard updates

### 9.2 Optional Add-ons
- Priority support pass: $4.99/mo
- Cosmetic theme pack bundle: $9.99 one-time
- Team/duo bundle discount during launches

### 9.3 Refund/Abuse Policy
- 48-hour conditional refund (technical incompatibility only)
- Fraud checks on payment/HWID anomalies
- Strict account sharing prohibition

---

## 10) 6-Month Update Roadmap

### Month 1 — Foundation Release (v1.0)
- Core loader, module framework, event bus, config + profiles
- Essential Combat/Movement/Render modules
- Initial docs + Discord onboarding

### Month 2 — Stability & UX (v1.1)
- Crash analytics pipeline
- GUI polish pass + HUD editor improvements
- Preset templates + import/export UX

### Month 3 — Automation Expansion (v1.2)
- JS API v2 + script marketplace prototype
- Macro recorder + conditional chain editor
- AutoBuilder/route helper alpha

### Month 4 — Version Hardening (v1.3)
- 1.20.4/1.21.1 compatibility tuning
- Adapter optimization for packet/event overhead
- Expanded profile intelligence per server context

### Month 5 — Community Growth (v1.4)
- Creator program (config/script contributors)
- In-client changelog and announcement feed
- Better account dashboard + cloud profile sync

### Month 6 — Premium Maturity (v1.5)
- Theme editor overhaul
- Performance rewrite for low-end systems
- Long-term support branch + QA matrix expansion

---

## Appendix A — Quality & Release Gates
- Unit tests: settings, profile migrations, event ordering
- Integration tests: multi-version startup and module load
- Visual QA: GUI regressions + HUD scaling checks
- Security checks: signature validation and tamper alerts

## Appendix B — KPI Targets
- Activation success rate > 97%
- Crash-free sessions > 99%
- 30-day retention > 55%
- Avg support response < 12h
- Monthly update cadence: at least 2 stable patches
