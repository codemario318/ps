const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input: string = "";

const read = (line: string) => {
  input = line;
  rl.close();
};

const main = () => {
  const input = preprocess();
  console.log(solution());
};

const preprocess = () => {};

const solution = () => {};

rl.on("line", read);
rl.on("close", main);
