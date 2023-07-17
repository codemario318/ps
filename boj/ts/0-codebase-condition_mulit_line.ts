import * as readline from "readline";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let lines: string[] = [];

function read(line: string) {
  if (isCloseCondition()) {
    rl.close();
    return;
  }

  lines.push(line);

  rl.close();
}

function isCloseCondition(): boolean {
  return true;
}

function main() {
  const input: any[] = preprocess();
  const [a, b] = input;
  console.log(solution(a, b));
}

function preprocess(): any[] {
  return [];
}

function solution(a: number, b: number): any {
  return "";
}

rl.on("line", read);
rl.on("close", main);
