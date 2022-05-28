## Fpga study with open source software (on macos)

### Target

- [x] yosys: flash to hardware
- [ ] add logic
- [ ] blink: chisel to verilog
- [x] blink: use yosys flah to hardware
- [ ] a clock: i2c
- [ ] riscv64 cpu

### Hardware

- tang nano 4k
- tang nano 9k

### Resources

- [数电](https://www.bilibili.com/video/BV1aJ411R7Hd)
- [verilog](https://www.bilibili.com/video/BV12y4y1v7V3)
- https://www.xuetangx.com/course/THU08081000386/10322165?channel=i.area.learn_title
- https://github.com/buhe/fpga_study/blob/main/docs/chisel-book-chinese.pdf
- https://open.163.com/newview/movie/free?pid=M7A8MMH3M&mid=M7A8O2HFQ
- https://saiankit30.medium.com/how-to-simulate-verilog-models-on-macos-5a6f821b2c4f


### Simulate

```bash
brew install icarus-verilog
brew install --cask gtkwave
```

```bash
iverilog -o sample_tb.vvp sample_tb.v
```

### ✅ Flash to fpga

```bash
brew install yosys
pip install apycula
brew install openfpgaloader --HEAD

# install nextpnr
brew install eigen
# https://github.com/YosysHQ/nextpnr#nextpnr-gowin
cmake . -DARCH=gowin
make -j$(nproc)
sudo make install
```

### ✅ Verilog
```bash
yosys -D LEDS_NR=8 -p "read_verilog blinky.v; synth_gowin -json blinky.json"
nextpnr-gowin --json blinky.json --write pnrblinky.json --device GW1NSR-LV4CQN48PC6/I5 --cst tangnano4k.cst
gowin_pack -d GW1NSR-LV4CQN48PC6/I5 -o pack.fs pnrblinky.json
openFPGALoader -b tangnano4k pack.fs
```
[video](https://youtube.com/shorts/uIiRk0R6xPE)

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


