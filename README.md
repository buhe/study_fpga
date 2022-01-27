## hardware study with open soruce software

### Target

- [ ] riscv64

### Install

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

### Demo for example

```bash
# compile example
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

