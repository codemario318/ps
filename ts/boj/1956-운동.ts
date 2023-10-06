/**
 * 문제
V개의 마을와 E개의 도로로 구성되어 있는 도시가 있다. 도로는 마을과 마을 사이에 놓여 있으며, 일방 통행 도로이다. 마을에는 편의상 1번부터 V번까지 번호가 매겨져 있다고 하자.

당신은 도로를 따라 운동을 하기 위한 경로를 찾으려고 한다. 운동을 한 후에는 다시 시작점으로 돌아오는 것이 좋기 때문에, 우리는 사이클을 찾기를 원한다. 단, 당신은 운동을 매우 귀찮아하므로, 사이클을 이루는 도로의 길이의 합이 최소가 되도록 찾으려고 한다.

도로의 정보가 주어졌을 때, 도로의 길이의 합이 가장 작은 사이클을 찾는 프로그램을 작성하시오. 두 마을을 왕복하는 경우도 사이클에 포함됨에 주의한다.

입력
첫째 줄에 V와 E가 빈칸을 사이에 두고 주어진다. (2 ≤ V ≤ 400, 0 ≤ E ≤ V(V-1)) 다음 E개의 줄에는 각각 세 개의 정수 a, b, c가 주어진다. a번 마을에서 b번 마을로 가는 거리가 c인 도로가 있다는 의미이다. (a → b임에 주의) 거리는 10,000 이하의 자연수이다. (a, b) 쌍이 같은 도로가 여러 번 주어지지 않는다.

출력
첫째 줄에 최소 사이클의 도로 길이의 합을 출력한다. 운동 경로를 찾는 것이 불가능한 경우에는 -1을 출력한다.

예제 입력 1 
3 4
1 2 1
3 2 1
1 3 5
2 3 2
예제 출력 1 
3
출처
데이터를 추가한 사람: joonwu04, rhdqor213, zenith82114
 */
import fs from "fs";

const input: string[] = fs.readFileSync("/dev/stdin").toString().split(" ");

const V: number = parseInt(input.shift() ?? "0");
const E: number = parseInt(input.shift() ?? "0");
const paths: number[][] = input.map((item) => item.split("").map(Number));

const board: number[][] = [];

for (let i = 1; i <= V; i++) {
  const temp: number[] = [];

  for (let j = 1; j <= V; j++) {
    temp.push(Infinity);
  }

  board.push(temp);
}

paths.forEach(([s, e, c]) => {
  board[s][e] = c;
});

for (let k = 1; k <= V; k++) {
  board[k][k] = 0;

  for (let i = 1; i <= V; i++) {
    for (let j = 1; j <= V; j++) {
      board[i][j] = Math.min(board[i][k], board[k][j]);
    }
  }
}
