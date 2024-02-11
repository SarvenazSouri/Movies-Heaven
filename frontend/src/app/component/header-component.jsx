import React, { useState } from "react";
import "../globals.css";
import logo from "../../../public/LOGO-STREAM_HEAVEN.png";
import img_online from "../../../public/img_online.png";
import img_offline from "../../../public/img_offline.png";

const Header = ({
  onLoginClick,
  isLoggedIn,
  onLoginSuccess,
  onLogout,
  onListFilmClick,
  onSearchSubmit,
}) => {
  const handleLoginSuccess = () => {
    setLoggedIn(true);
  };

  const [ searchValue, setSearchValue] = useState('');

  const handleSearchChange = (event) => {
    setSearchValue(event.target.value);
  };

  const handleSearchSubmit = (event) => {
    event.preventDefault();
    let searchValue2 = searchValue
    setSearchValue("");
    onSearchSubmit(searchValue2);
  };

  return (
    <header>
      <div class="logo-nav">
        <div class="logo">
          <img src={logo.src} />
        </div>
        <div className="search-bar">
        <form onSubmit={handleSearchSubmit}>
          <input
            type="search"
            placeholder="Cherchez ici"
            value={searchValue}
            onChange={handleSearchChange}
          />
          <button type="submit">Chercher</button>
        </form>
      </div>
        <nav>
          <ul class="nav">
            {/* <li>
              <a href="#" onClick={onListFilmClick}>
                MOVIES
              </a>
            </li> */}
            <li>
              <a href="#" onClick={isLoggedIn ? onLogout : onLoginClick}>
                {isLoggedIn ? "LOGOUT" : "LOGIN"}
              </a>
              {isLoggedIn ? (
                <img src={img_online.src} alt="Online" />
              ) : (
                <img src={img_offline.src} alt="Offline" />
              )}
            </li>
          </ul>
        </nav>
      </div>
       
    </header>
  );
};

export default Header;
