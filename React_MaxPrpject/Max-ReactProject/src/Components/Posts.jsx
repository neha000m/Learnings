import classes from './Post.module.css';
//const names = ["Neha Mishra", "Max Muller"];
function Posts(Props) {

   // const chosenNames=Math.random() > 0.5 ? names[0] : names[1];
            //this .post will be with many classnames so react does some transformation in background and make these classes unique so when we inspect in fE the CLASS NAME appear will be different

    
return (
         <div className={classes.post}> 
            <p className={classes.author}>{Props.author}</p>
            <p className={classes.body}>{Props.body}</p>
            
        </div>
    )
}

export  default Posts;