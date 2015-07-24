var readline = require('readline');
var rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  terminal: false
});

rl.on('line', function(line) {
  console.log(getFactors(line));
});


// computing takes a super long time
// needs a better algorithm, but what?

function getFactors(n){

n = new Number(n);
x = n+1;
y = n*x/2;

var factors = [],

for(var i = 1; i<= y; i++){
  // q = y/i;

  if(y % i == 0){
    factors.push(i);
  }
}
return factors;
}
