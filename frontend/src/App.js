import './App.css';
import LoginButton from './components/LoginButton';
import LogoutButton from './components/LogoutButton';

function App() {
  return (
    <div className="App">
      <h1>Welcome to HackerMeet</h1>
      <img src="/logo.png" alt="logo" style={{maxWidth: "100px", display: "inline-block"}} />
      <br />
      <LoginButton style={{display: "inline-block"}} />
      <LogoutButton />
    </div>
  );
}

export default App;
