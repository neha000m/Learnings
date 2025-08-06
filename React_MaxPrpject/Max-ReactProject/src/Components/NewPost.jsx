import classes from './NewPost.module.css';
import PostList from './PostList';
import {useState} from 'react';

function NewPost({onCancel , onAddPost}) {
   const[enteredBody,setEnteredBody] = useState(' ');
    const[enteredAuthor,setEnteredAuthor] = useState('');
   
    function changeBodyHandler(event){
      setEnteredBody(event.target.value);
      }
    function changeAuthorHandler(event){
      setEnteredAuthor(event.target.value);
      }

      function submitHandler(event){
        event.preventDefault();
        // prevents sending http request to browser hence stop reloading from server
        const postData= {
          body:enteredBody,
          author:enteredAuthor
        };
        onAddPost(postData);
        onCancel();

      }


  return (
    <form className={classes.form} onSubmit ={submitHandler}>
      <p>
        <label htmlFor="body">Text</label>
        <textarea id="body" required rows={3} onChange ={changeBodyHandler}/>
      </p>
      <p>
        <label htmlFor="name">Your name</label>
        <input type="text" id="name" required  onChange={changeAuthorHandler}/>
      </p>
      <p className={classes.actions}></p>
      <button type="button" onClick={onCancel}>Cancel</button>
      <button>Submit</button>
    </form>
  );
}

export default NewPost;
