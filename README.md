## Fpga study with open source software

### Target

- [ ] yosys: flash to hardware
- [ ] blink: chisel to verilog
- [ ] blink: use yosys flah to hardware
- [ ] a clock
- [ ] riscv64 cpu

### Hardware

- tang nano 4k
- tang nano 9k

### Basic 

- https://www.bilibili.com/video/BV1aJ411R7Hd

### Install open source toolchain

```bash
brew install yosys
pip install apycula
brew install openfpgaloader

# install nextpnr
brew install eigen
# https://github.com/YosysHQ/nextpnr#nextpnr-gowin
cmake . -DARCH=gowin
make -j$(nproc)
sudo make install
```

### Verilog

```bash
# compile example
cd examples
yosys -D LEDS_NR=8 -p "synth_gowin -json blinky.json" blinky.v
# nextpnr-gowin --json blinky.json --write pnrblinky.json --device GW1NR-UV9QN881C6/I5 --cst tec0117.cst

nextpnr-gowin --json blinky.json --write pnrblinky.json --device GW1NSR-LV4CQN48PC7/I6 --cst tangnano4k.cst
gowin_pack -d GW1NSR-LV4CQN48PC7/I6 -o pack.fs pnrblinky.json
# test?
brew install xdot
gowin_unpack -d GW1NSR-LV4CQN48PC7/I6 -o unpack.v pack.fs
yosys -p "read_verilog -lib +/gowin/cells_sim.v; clean -purge; show" unpack.v
# change to your board
openFPGALoader -b tangnano4k pack.fs
```
### Chisel
```bash
make led_v
yosys -p "synth_gowin -top Led -json blinky.json" output/Led.v

nextpnr-gowin --json blinky.json --write pnrblinky.json --device GW1NSR-LV4CQN48PC7/I6 --cst examples/tangnano4k.cst

gowin_pack -d GW1NSR-LV4CQN48PC7/I6 -o pack.fs pnrblinky.json

```



 just need to specify how many LEDs your board has. For example for my TangNano with three LEDs:

```bash
yosys -D LEDS_NR=3 -p "synth_gowin -json blinky.json" blinky.v
```

so,9k is LEDS_NR=6,look up 9k.cst
