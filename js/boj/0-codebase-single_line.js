const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = '';

const read = (line) => {
    input = line;
    rl.close();
}

const main = () => {
    const input = preprocess();
    console.log(solution(input))
}

const preprocess = () => {
}

const solution = () => { 
}

rl.on('line', read);
rl.on('close', main);