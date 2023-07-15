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
}

const solution = () => { 
}

const readline = require('readline');

rl.on('line', read);
rl.on('close', main);