import * as readline from "readline";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let lines: string[] = [];

function read(line: string) {
  if (isCloseCondition(line)) {
    rl.close();
    return;
  }

  lines.push(line);

  rl.close();
}

function isCloseCondition(line: string): boolean {
  return line === "end";
}

function main() {
  const input: any[] = parseInputLines();

  input.forEach((line) => {
    console.log(solution(line));
  });
}

function parseInputLines(): string[] {
  return lines.map(parseInputLine);
}

function parseInputLine(line: string): string {
  return line.trim();
}

const ALOW_CHARS = ["e", "o"];
const VOWELS = ["a", "e", "i", "o", "u"];
const CONSONANTS = [
  "b",
  "c",
  "d",
  "f",
  "g",
  "h",
  "j",
  "k",
  "l",
  "m",
  "n",
  "p",
  "q",
  "r",
  "s",
  "t",
  "v",
  "w",
  "x",
  "y",
  "z",
];

function solution(password: string): string {
  return "";
}

function isSafety(password: string): boolean {
  return (
    hasVowel(password) &&
    !hasSequentialChars(password) &&
    !hasSequentialSameChars(password)
  );
}

function hasVowel(password: string): boolean {
  return true;
}

function hasSequentialChars(password: string): boolean {
  return hasSequentialVowel(password) || hasSequentialConsonants(password);
}

function hasSequentialVowel(password: string, limit: number = 3): boolean {
  return true;
}

function hasSequentialConsonants(password: string, limit: number = 3): boolean {
  return true;
}

function hasSequentialSameChars(
  password: string,
  limit: number = 2,
  alowChars: string[] = ALOW_CHARS
): boolean {
  const sequentialChars: string[] = getSameChars(limit);
  return sequentialChars.find((char) => !alowChars.find) !== undefined;
}

function getSameChars(limit: number = 2): string[] {
  return [];
}

rl.on("line", read);
rl.on("close", main);
