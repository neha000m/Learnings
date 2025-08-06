import PostList from "./Components/PostList";
import MainHeader from "./Components/MainHeader";
import {useState} from 'react';

function App() {
      const[isModalVisible,setModalIsVisible] = useState(false);
function showmodalHandler(){
        
          setModalIsVisible(true);
        
    }

    function hideModalhandler(){
        
          setModalIsVisible(false);  
        
    }
  return (
    <>
 <MainHeader onCreatePost ={showmodalHandler}/>
 <main>
    <PostList isPosting={isModalVisible} onStopPosting={hideModalhandler}/>
</main>
</>

  );
}

export default App;
  