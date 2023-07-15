const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let count = null;
const lines = [];

const read = (line) => {
    if (count === null) {
        count = Number(line);
    }

    if (isCloseCondition()) {
        rl.close();
    }

    lines.push(line);
    count--;
}

const isCloseCondition = () => {
    return count === 0;
}

const main = () => {
    const input = preprocess();
    console.log(solution());
}

const preprocess = () => {
}

const solution = () => {
}

rl.on('line', read);
rl.on('close', main);