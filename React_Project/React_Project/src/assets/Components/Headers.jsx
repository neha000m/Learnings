import image from "../config.png";; // Importing the image
import React from 'react'; // Importing React
// Importing the Header component
// This component displays a header with an image and a description
// The description is randomly selected from a predefined list
// The image is a stylized atom, representing React's core concept
// The header includes a title and a brief description of React Essentials
 const descriptions=['Fundamental',' Core', 'Crucial'];

function genRandomValues(values) {  
  return Math.floor(Math.random() * (values.length));
}

export default function Header(){
 const desc =descriptions[genRandomValues(2)];
  return (
    <header>
        <img src= {image} alt="Stylized atom" />
        <h1>React Essentials</h1>
        <p>
          {desc} React concepts you will need for almost any app you are
          going to build!
        </p>
      </header>

  )}  