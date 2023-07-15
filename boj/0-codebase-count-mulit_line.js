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
        return;
    }

    lines.push(line);
    count--;

    if (count === 0) {
        console.log(lines);
        rl.close();
        return;
    }
}

const main = () => {
    const input = preprocess();
    console.log(solution());
}

const preprocess = () => {
    return lines.map(parse);
}

const parse = (line) => {
    return line;
}

const solution = () => {
}

rl.on('line', read);
rl.on('close', main);