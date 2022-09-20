import './App.css';
import LoginButton from './components/LoginButton';
import LogoutButton from './components/LogoutButton';
import { useAuth0 } from '@auth0/auth0-react';
import { Link } from 'react-router-dom';

function App() {
  const { user, isAuthenticated, getAccessTokenSilently} = useAuth0();
  // const [userMetadata, setUserMetadata] = useState(null);

  let button;
  if (isAuthenticated) {
    console.log("isAuthenticated " + user);
    button = <LogoutButton />
  } else {
    console.log("is not Authenticated ");
    button = <LoginButton style={{display: "inline-block"}} />;
  }

  const getUserMetadata = async () => {
    console.log("getting access token");

    const domain = process.env.REACT_APP_AUTH0_API_AUDIENCE;
    console.log(domain);

    try {
      const accessToken = await getAccessTokenSilently({
        audience: domain,
        // scope: "read:current_user",
      });

      console.log("accessToken: " + accessToken);

      // const userDetailsByIdUrl = `https://${domain}/api/v2/users/${user.sub}`;

      // const metadataResponse = await fetch(userDetailsByIdUrl, {
      //   headers: {
      //     Authorization: `Bearer ${accessToken}`,
      //   },
      // });

      // const { user_metadata } = await metadataResponse.json();

      // setUserMetadata(user_metadata);
    } catch (e) {
      console.log("error " + e.message);
    }
  };

  // function f() {

  // }

  return (
    <div className="App">
      <h1>Welcome to HackerMeet</h1>
      <img src="/logo.png" alt="logo" style={{maxWidth: "100px", display: "inline-block"}} />
      <br />
      {button}
      <br />
      {isAuthenticated && <button onClick={() => getUserMetadata()}>Make Request</button>}
      <br />
      {isAuthenticated && <Link to="/profile">My Profile</Link>}
    </div>
  );
}

export default App;
