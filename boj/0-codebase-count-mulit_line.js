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

    if (count === 0) {
        rl.close();
    }

    lines.push(line);
    count--;
}

const main = () => {
}

const solution = () => {
}

rl.on('line', read);
rl.on('close', main);