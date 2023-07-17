import * as readline from "readline";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let count: number | null = null;
const lines: string[] = [];

function read(line: string) {
  if (count === null) {
    count = Number(line);
    return;
  }

  lines.push(line);
  count--;

  if (count === 0) {
    rl.close();
    return;
  }
}

function main() {
  const input: any[] = preprocess();
  console.log(solution());
}

function preprocess(): any[] {
  return [];
}

function solution(): any {
  return "";
}

rl.on("line", read);
rl.on("close", main);
