import * as readline from "readline";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input: string = "";

function read(line: string) {
  input = line;
  rl.close();
}

function main() {
  const input: number[] = preprocess();
  const [a, b] = input;
  console.log(solution(a, b));
}

function preprocess(): number[] {
  return input.split(" ").map(Number);
}

function solution(a: number, b: number) {
  return a + b;
}

rl.on("line", read);
rl.on("close", main);
