# bedrock-mechanics

A mod for Fabric that ports Bedrock Edition mechanics to Java Edition. The controller support should be working on any
controller by now.

This project is in the experimental phase, so don't expect the latest versions to have many features. Snapshots can be
tested through the artifacts generated by GitHub Actions.

Since the code is not version dependent, this mod should be able to run on all game versions supported by Fabric.

> Want to help by submitting a bug report or a feature suggestion that should be ported to Java? I would appreciate it,
> you can use the issues tab for that. I can also answer any questions there or on Discord (nekkan#9515).

## Planned features

List of planned resources. Those that have already been added are marked with a ☑.

* [x] Controller Support
  * [x] Can add any binding easily through the API
  * [x] Basic stuff, such as axis and button handling. This includes some essential bindings (walk, look, drop item,
    etc.)
  * [ ] Inventory interaction support
  * [ ] Other menus interaction support
* [x] Paper doll
* [x] Show location and FPS under paper doll
* [ ] Bedrock water color tint
* [ ] Bedrock Edition exclusive animations
  * [ ] Drowned swimming animation
  * [ ] Eating animation
  * [ ] Burning animation
  * [ ] Suffocation animation
  * [ ] Nether portal entering animation
  * [ ] Steve and Alex eye blinking
  * [ ] Fade-in chunk loading
    * [ ] Support for Sodium
    * [ ] Support for OptiFabric
* [x] Bedrock mechanics
  * [x] Sneaking activates shield
  * [ ] Accurate effect timer (don't show it as infinite)
  * ~~❌ Accurate block placement (in order to better implement the front block
    placing)~~ ([Use this instead][accurate-block-placement])
  * [ ] Front block placing
  * [ ] Colorful cauldron water
  * [ ] Fill cauldrons with lava
  * [ ] Cauldrons filled with water can extinguish fire in players
  * [ ] Highlight slots when hovering
  * [ ] Show enchantments and background when held item tooltip is displayed

[accurate-block-placement]: https://www.curseforge.com/minecraft/mc-mods/accurate-block-placement  
