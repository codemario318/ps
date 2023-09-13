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

  lines.push(line.trim());
  count--;

  if (count === 0) {
    rl.close();
    return;
  }
}

type Position = {
  x: number;
  y: number;
};

type Mark = "*" | "_";

class BodyPart {
  private hart: Position;
  private end: Position;

  constructor(hart: Position, end: Position) {
    this.hart = hart;
    this.end = end;
  }

  getSize() {
    return (
      Math.abs(this.hart.x - this.end.x) + Math.abs(this.hart.y - this.end.y)
    );
  }
}

const BODY_MARK: Mark = "*";
const HART_OFFSET: number[][] = [
  [0, 1],
  [1, 0],
  [-1, 0],
  [0, -1],
];

function main() {
  const input: string[][] = parseInputLines();
  console.log(solution(input));
}

function parseInputLines(): string[][] {
  return lines.map((line) => line.split(""));
}

function solution(board: string[][]): {
  hart: Position;
  leftArm: Position;
  rightArm: Position;
  leftLeg: Position;
  rightLeg: Position;
} {
  const hart: Position = findHart(board);
  return {};
}

function findHart(board: string[][]): Position {
  const n: number = board.length - 1;

  for (let row = 1; row < n; row++) {
    for (let col = 1; col < n; col++) {
      const item: string = board[row][col];
    }
  }

  return {
    x: 0,
    y: 0,
  };
}

function checkHart(board: string[][], position: Position) {
  return (
    OFFSET.find((offset) => !checkMark(board, position, offset, BODY_MARK)) !==
    undefined
  );
}

function checkMark(
  board: string[][],
  position: Position,
  offset: number[],
  mark: Mark
): boolean {
  const [col, row] = offset;
  const { x, y } = position;
  try {
    return board[x + row][y + col] === mark;
  } catch (error) {
    return false;
  }
}

function findBodyPart(board: string[], hart: Position, offset: Position);

rl.on("line", read);
rl.on("close", main);
