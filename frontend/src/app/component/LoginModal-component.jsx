import React, { useState, useEffect } from "react";
import Modal from "react-modal";
import img_online from "../../../public/img_online.png";
import CreateModal from "../component/inscrireModal-component";
import imageCompte from "../../../public/Moncompte.png";
 
import axios from "axios";
 
// Composant principal représentant la fenêtre modale de connexion
const LoginModal = ({
  onClose, // Fonction pour fermer la fenêtre modale
  showLoginModal, // Indicateur si la fenêtre modale est visible
  onCreateAccountClick, // Fonction pour gérer le clic sur "Create ID"
  onLoginSuccess, // Fonction à exécuter en cas de connexion réussie
}) => {
  // Déclaration des états
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [backendError, setBackendError] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");
  const [showCreateModal, setShowCreateModal] = useState(false);
  const [barreLateraleOuverte, setBarreLateraleOuverte] = useState(false);
  const [user, setUser] = useState(null);

  useEffect(() => {
    setUsername("");
    setPassword("");
  }, [showLoginModal]);
 
  // Fonction pour gérer la tentative de connexion
  const handleLogin = () => {
    const loginData = {
      email: username,
      password: password,
    };
 
    axios({
      method: "post",
      url: "http://localhost:8081/ProjetBack_end/ServletUserInfo/donneUser",
      timeout: 4000,
      data: loginData,
    })
      .then((response) => {
        if (response.status === 200) {
          onLoginSuccess();
          setUser(response.data);
          onClose();
        } else {
          setBackendError(true);
          setErrorMessage("Email or password is incorrect.");
        }
      })
      .catch((error) => {
        console.error("timeout exceeded");
        setBackendError(true);
        setErrorMessage("Error connecting to the server.");
      });
  };
 
  // Fonctions pour ouvrir et fermer la barre latérale
  const ouvrir = () => {
    setBarreLateraleOuverte(true);
  };
 
  const fermer = () => {
    setBarreLateraleOuverte(false);
  };
 
  // Effet pour afficher dans la console chaque fois que l'état user change
  useEffect(() => {
    console.log(user);
  }, [user]);
 
  // Styles dynamiques en fonction de l'état de la barre latérale
  const barreLateraleStyle = {
    width: barreLateraleOuverte ? "250px" : "0",
    padding: barreLateraleOuverte ? "20px" : "0",
    zIndex: 0,
  };
 
  const mainStyle = {
    marginLeft: barreLateraleOuverte ? "250px" : "0",
    zIndex: 1,
  };
 
  const overlayStyle = {
    display: barreLateraleOuverte ? "block" : "none",
  };
 
  // Fonction pour gérer le clic sur "Create ID"
  const handleInscrire = () => {
    setShowCreateModal(true);
  };
 
  // Fonction pour fermer la fenêtre modale d'erreur
  const closeErrorModal = () => {
    setBackendError(false);
  };

  const closeCreateModal = () => {
    setShowCreateModal(false);
  };
 
  return (
    <div>
      {/* Fenêtre modale de connexion */}
      <Modal
        className="modal"
        isOpen={showLoginModal}
        onRequestClose={onClose}
        contentLabel="Login Modal"
      >
        <h1 onClick={onClose}>X</h1>
        <div className="modal-content">
          <div className="img-content">
            <div className="image-login">
              <img src={img_online.src} alt="Online" />
            </div>
            <div className="content">
              <h2>USER LOGIN</h2>
              <input
                type="email"
                placeholder="Email"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
              <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              {backendError && (
                // Fenêtre modale d'erreur en cas d'échec de connexion
                <div className="modal-login-ERROR">
                  <p className="error-message">{errorMessage}</p>
                  <button onClick={closeErrorModal}>OK</button>
                </div>
              )}
              <div className="modal-BTN">
                <button className="login-BTN" onClick={handleLogin}>
                  LOGIN
                </button>
                <button className="create-BTN" onClick={handleInscrire}>
                  CREATE ID
                </button>
                <CreateModal
                onClose={() => {
                  closeCreateModal();
                }}
                isOpen={showCreateModal}
                onUserCreated={() => {
                  closeCreateModal();
                }}
              />
              </div>
            </div>
          </div>
        </div>
      </Modal>
      <div>
        {/* Affichage des informations personnelles dans la barre latérale */}
        <div className="monCompte">
          <div
            id="barreLaterale"
            className="barreLaterale"
            style={barreLateraleStyle}
          >
            <div id="Utilisateur">
              <div id="image_monCompte">
                <img
                  src={imageCompte.src}
                  height="100px"
                  width="100px"
                  alt="imageCompte"
                />
              </div>
 
              <div id="infoPersonnelle">
                <h2>Information Personnelle</h2>
                {user && (
                  <div>
                    <h4>Nom :</h4> <b>{user.nom}</b>
                    <h4>Prénom :</h4> <b>{user.prenom}</b>
                  </div>
                )}
              </div>
            </div>
          </div>
          <div id="main" style={mainStyle}>
            <button id="bouton_OuvrirLaBarre" onClick={ouvrir}></button>
          </div>
        </div>
        {/* Overlay pour fermer la barre latérale */}
        <div id="overlay" style={overlayStyle} onClick={fermer}></div>
      </div>
    </div>
  );
};
 
export default LoginModal;
