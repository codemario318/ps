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
  const input: any[] = parseInputLines();
  console.log(solution());
}

function parseInputLines(): any[] {
  return [];
}

function parseInputLine(): any {}

function solution(): any {
  return "";
}

rl.on("line", read);
rl.on("close", main);
