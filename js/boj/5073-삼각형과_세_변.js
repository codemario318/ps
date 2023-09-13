const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => main(line));

const main = (line) => {
    const edges = line.split(' ').map(n => Number(n));
    const total = sum(edges);

    if (total === 0) {
        rl.close();
    } else {
        console.log(solution(edges));
    }
}

const solution = (edges) => {
    const sortedEdges = getSortedEdges(edges);

    if (isInvalid(sortedEdges)) {
        return 'Invalid';
    }

    if (isEquilateral(sortedEdges)) {
        return 'Equilateral';
    }

    if (isIsosceles(sortedEdges)) {
        return 'Isosceles'
    }

    if (isScalene(sortedEdges)) {
        return 'Scalene'
    }
}

const sum = (numbers) => {
    return numbers.reduce((total, current) => total + current, 0);
}

const getSortedEdges = (edges) => {
    return [...edges].sort((a, b) => a - b);
}

const isInvalid = (edges) => {
    const [a, b, c] = edges;
    return (a + b) <= c;
}

const isEquilateral = (edges) => {
    const total = sum(edges);
    return total === (edges[0] * edges.length);
}

const isIsosceles = (edges) => {
    const [a, b, c] = edges;
    return a === b || a === c || b === c;
}

const isScalene = (edges) => {
    const [a, b, c] = edges;
    return a !== b && a !== c && b !== c;
}
