import Posts from './Posts';
import classes from './PostsList.module.css';
import NewPost from './NewPost';
import Modal from './Modal.jsx';
import {useState , useEffect} from 'react';



function PostList({isPosting, onStopPosting}){
        const[posts, setPosts]= useState([]);

   // fetch('http://localhost:8080/posts').then(response => response.json()).then(data => {setPosts(data.posts);
   // });
// fetch is used to send http request to server and get the data from server
// we are using then method to get the response from server and then convert it to json format
//but this will cause infinite loop as it will keep fetching data from server every time the component is rendered
//hence we will use useEffect hook to fetch data from server only once when the component is mounted
//useEffect is a hook that allows you to perform side effects in your components
useEffect(() => {
    async  function  fetchPosts() {
const response= await fetch('http://localhost:8080/posts');
    const responsedata = await response.json();
   setPosts(responsedata.posts);
        }


    fetchPosts();
    // this will fetch the data from server only once when the component is mounted
    // if we pass an empty array as second argument to useEffect, it will run only once
    // if we pass a variable or state as second argument, it will run whenever that variable or state changes
    // if we pass no second argument, it will run after every render
    // but we want to fetch data only once when the component is mounted, so we pass an empty array
    // this is similar to componentDidMount lifecycle method in class components

    
    ;},[]);


function addPostHandler(postData){

    fetch('http://localhost:8080/posts', {
        method: 'POST',
        body: JSON.stringify(postData),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).then((response) => {
        if(response.ok){
            return response.json();
        }
        throw new Error('Something went wrong!');
    }
    )
   setPosts((existingPosts)=>[postData, ...existingPosts]);
    // when new state depends on old state

}
    

    // we are setting const as everytime on reinitiating the body will ch
    return (
       <>{isPosting && ( <Modal onClose={onStopPosting}>

        <NewPost  onCancel={onStopPosting} onAddPost={addPostHandler}/>
        </Modal> )}

        { posts.length>0 &&(

        <ul className={classes.posts}>
        
       {posts.map((post) => ( <Posts key= {post.body} author={post.author} body={post.body}/>))}
 </ul>
        )}
 
 { posts.length===0 && (
<div style ={{textAlign: 'center' , color :'white'}}>
    <h2>There are no posts yet.</h2>
    <p>Start adding some.....</p>
    </div> )}
    </>
    
)}
// {isFetching && (
// <div style={{textAlign: 'center' , color: 'white'}}>
//     <p>Loading posts...</p>
// </div>
// )}
export default PostList;    