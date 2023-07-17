import * as readline from "readline";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let count: number | null = null;
let target: number | null = null;

const lines: string[] = [];

function read(line: string) {
  if (count === null) {
    [count, target] = line.split(" ").map(Number);
    return;
  }

  lines.push(line);
  count--;

  if (count === 0) {
    rl.close();
    return;
  }
}

interface Team {
  teamNumber: number;
  gold: number;
  silver: number;
  bronze: number;
}

function main() {
  const teams: Team[] = parseInputLines();
  const targetTeamIndex: number = target ?? 0;

  if (targetTeamIndex === 0) {
    throw new Error("잘못된 입력!");
  }

  console.log(solution(targetTeamIndex, teams));
}

function parseInputLines(): Team[] {
  return lines.map(parseInputLine);
}

function parseInputLine(line: string): Team {
  const [teamNumber, gold, silver, bronze] = line.split(" ").map(Number);
  return {
    teamNumber,
    gold,
    silver,
    bronze,
  };
}

function solution(targetTeamNumber: number, teams: Team[]): number {
  teams.sort(compare);

  const targetTeamIndex: number = teams.findIndex(
    (team: Team) => team.teamNumber == targetTeamNumber
  );
  const targetTeam: Team = teams[targetTeamIndex];

  const rankStartIndex: number = teams.findIndex((team: Team) =>
    isEqualRankTeam(targetTeam, team)
  );

  return rankStartIndex + 1;
}

function compare(teamA: Team, teamB: Team): number {
  if (teamA.gold !== teamB.gold) {
    return teamB.gold - teamA.gold;
  }

  if (teamA.silver !== teamB.silver) {
    return teamB.silver - teamA.silver;
  }

  if (teamA.bronze !== teamB.bronze) {
    return teamB.bronze - teamA.bronze;
  }

  return 0;
}

function isEqualRankTeam(teamA: Team, teamB: Team): boolean {
  return (
    teamA.gold === teamB.gold &&
    teamA.silver === teamB.silver &&
    teamA.bronze === teamB.bronze
  );
}

rl.on("line", read);
rl.on("close", main);
