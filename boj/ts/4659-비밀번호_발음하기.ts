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
}

function isCloseCondition(line: string): boolean {
  return line === "end";
}

function main() {
  const input: string[] = parseInputLines();

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

const ALOW_CHARS: string[] = ["e", "o"];
const VOWELS: string = "aeiou";
const CONSONANTS: string = "bcdfghjklmnpqrstvwxyz";

const SEQ_LIMIT: number = 3;
const SAME_SEQ_LIMIT: number = 2;

function solution(password: string): string {
  return isSafety(password)
    ? `<${password}> is acceptable.`
    : `<${password}> is not acceptable.`;
}

function isSafety(password: string): boolean {
  return (
    hasVowel(password) &&
    !hasSequentialChars(password) &&
    !hasSequentialSameChars(password)
  );
}

function hasVowel(password: string): boolean {
  const vowelRegex: RegExp = getSequentialRegex(VOWELS, 1);
  return vowelRegex.test(password);
}

function hasSequentialChars(
  password: string,
  limit: number = SEQ_LIMIT
): boolean {
  const vowelSeqRegex: RegExp = getSequentialRegex(VOWELS, limit);
  const consonantSeqRegex: RegExp = getSequentialRegex(CONSONANTS, limit);
  return vowelSeqRegex.test(password) || consonantSeqRegex.test(password);
}

function getSequentialRegex(chars: string, limit: number): RegExp {
  return new RegExp(`[${chars}]\{${limit},\}`, "gi");
}

function hasSequentialSameChars(
  password: string,
  limit: number = SAME_SEQ_LIMIT,
  alowChars: string[] = ALOW_CHARS
): boolean {
  const sequentialChars: string[] = getSequentialSameChars(password, limit);
  return (
    sequentialChars.find((char) => !alowChars.includes(char)) !== undefined
  );
}

function getSequentialSameChars(password: string, limit: number): string[] {
  const result: string[] = [];
  const [_, ...chars] = [...password];

  let curChar: string = password.charAt(0);
  let count: number = 1;

  chars.push("end");

  chars.forEach((char) => {
    if (curChar === char) {
      count++;
    } else {
      if (count >= limit) {
        result.push(curChar);
      }

      curChar = char;
      count = 1;
    }
  });

  return result;
}

rl.on("line", read);
rl.on("close", main);
