import { useState } from 'react';

import Header from './assets/Components/Headers.jsx';
import {CORE_CONCEPTS} from './data.js';
import { TabButton } from './assets/TabButton.jsx';
import {EXAMPLES} from './data.js'; 

function CoreConcepts({ image, title, description }) {
  return (
    <li>
      <img src={image} alt={title} />
      <h2>{title}</h2>
      <p>{description}</p>
    </li>
  );
}

function App() {
  const [selectedTopic,setSelectedTopic ]= useState();
  //when first rendered, seletedTopic is set to a default message
    
  function handleSelect(selectedTab) {
    setSelectedTopic(selectedTab);
    
    console.log(selectedTopic);
    //it is used to update the state of the selected topic but in the next cycle of rendering
  }
  console.log('App component rendered');
  return (
    <div>
      <Header />
      <main>
        <section id="core-concepts">
          <h2>Core Concepts</h2>
          <ul>
            {CORE_CONCEPTS.map(core_concept=>(<CoreConcepts key={core_concept.title}{...core_concept}/>))}
           {/* <CoreConcepts {...CORE_CONCEPTS[0]} />
            <CoreConcepts {...CORE_CONCEPTS[1]} />
            <CoreConcepts {...CORE_CONCEPTS[2]} />
            <CoreConcepts {...CORE_CONCEPTS[3]} /> */}
          </ul>
        </section>
        <h2>Time to get started!</h2>
      </main>
      <section id="examples"> 
        <h2>Examples </h2>
        <menu>
          <TabButton isSelected ={selectedTopic=== 'Components'} onSelect ={()=>handleSelect('Components')}>Components</TabButton>
          <TabButton isSelected ={selectedTopic==='JSX'} onSelect ={()=>handleSelect('JSX')}>JSX</TabButton>
          <TabButton isSelected ={selectedTopic==='Props'} onSelect ={()=>handleSelect('Props')}>Props</TabButton>
          <TabButton isSelected ={selectedTopic==='State'} onSelect ={()=>handleSelect('State')}>State</TabButton>
        </menu> 
         {!selectedTopic ? <p>Select a topic to see the example.</p> : (<div id = "tab-content">
         
          <h3>{EXAMPLES[selectedTopic].title}</h3>
          <p>{EXAMPLES[selectedTopic].description}</p>
          <pre>
            <code>{EXAMPLES[selectedTopic].code}</code>
          </pre>
        </div>)}
       
      
      </section>
    </div>
  );
}

export default App;
