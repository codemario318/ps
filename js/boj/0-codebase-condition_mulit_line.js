const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const lines = [];

const read = (line) => {
    if (isCloseCondition()) {
        rl.close();
        return;
    }
    
    lines.push(line);
}

const isCloseCondition = () => {
    return true;
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