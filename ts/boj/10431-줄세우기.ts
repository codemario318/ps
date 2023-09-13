import * as readline from "readline";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let count: number | null = null;
const lines: string[] = [];

const read = (line: string) => {
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
};

interface Input {
  caseNumber: number;
  studentHeights: number[];
}

function main() {
  const inputs: Input[] = parseInputLines();
  inputs.forEach((input: Input) => {
    const { caseNumber, studentHeights }: Input = input;
    console.log(`${caseNumber} ${solution(studentHeights)}`);
  });
}

function parseInputLines(): Input[] {
  return lines.map(parseInput);
}

function parseInput(line: string): Input {
  const [caseNumber, ...studentHeights] = line.split(" ").map(Number);
  return {
    caseNumber,
    studentHeights,
  };
}

function solution(studentHeights: number[]): number {
  let sortedStudents: number[] = [];

  return studentHeights.reduce((totalMoveCount, height) => {
    const { moveCount, students } = getMoveStudentCount([
      ...sortedStudents,
      height,
    ]);

    sortedStudents = students;
    return totalMoveCount + moveCount;
  }, 0);
}

function getMoveStudentCount(students: number[]): {
  moveCount: number;
  students: number[];
} {
  let moveCount: number = 0;

  for (let index = students.length - 1; index > 0; index--) {
    const studentA = students[index - 1];
    const studentB = students[index];

    if (studentA <= studentB) {
      break;
    }

    moveFront(students, index);
    moveCount++;
  }

  return {
    moveCount,
    students,
  };
}

function moveFront(students: number[], index: number) {
  const temp = students[index];
  students[index] = students[index - 1];
  students[index - 1] = temp;
}

rl.on("line", read);
rl.on("close", main);
