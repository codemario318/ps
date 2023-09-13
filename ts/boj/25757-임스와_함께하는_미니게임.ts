import * as readline from "readline";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let count: number | null = null;
let gameTitle: string = "";

const lines: string[] = [];

function read(line: string) {
  if (count === null) {
    const [tempCount, tempGame] = line.split(" ");
    count = Number(tempCount);
    gameTitle = tempGame;
    return;
  }

  lines.push(line.trim());
  count--;

  if (count === 0) {
    rl.close();
    return;
  }
}

function main() {
  console.log(solution(gameTitle, lines));
}

const gamePlayerCounts: Map<string, number> = new Map([
  ["Y", 1],
  ["F", 2],
  ["O", 3],
]);

function solution(game: string, playerIds: string[]): number {
  const playerCount: number | undefined = gamePlayerCounts.get(game);

  if (playerCount === undefined) {
    throw new Error("잘못된 입력!");
  }

  return getPlayCount(playerCount, playerIds);
}

function getPlayCount(playerCount: number, playerIds: string[]): number {
  const players = new Set(playerIds);
  return Math.floor(players.size / playerCount);
}

rl.on("line", read);
rl.on("close", main);
