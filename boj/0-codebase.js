const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => main(line));

const main = (line) => {
    rl.close();
}

const solution = () => { 
}
