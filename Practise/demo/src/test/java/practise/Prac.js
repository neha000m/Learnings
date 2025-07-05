

const age=21;

function checkAge() {
   //ternary operator
   return age >= 18 ? "you are an adult" : "you are a minor";
}

switch(true){
    case age>=18 :
        console.log("you are an adult");
        break;
    case age<18 :
        console.log("you are a minor");
        break;
    default:        
    console.log("you are just an adult");
}

console.log(checkAge());
