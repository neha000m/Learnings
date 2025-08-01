import Link from 'next/link'

export default function Home() {
  console.log('Rendering Home Page');
  return (
    <main>
      <img src="/logo.png" alt="A server surrounded by magic sparkles." />
      <h1>Welcome to this NextJS Course!</h1>
      <p>🔥 Let&apos;s get started! 🔥</p>
      <p><Link href = "/about">About Us</Link></p>
      //link will render the page as single page application
    </main>
  );
}
