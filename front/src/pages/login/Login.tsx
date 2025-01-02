import React, { useState } from "react";
import { useAuth } from "./AuthContext";
import { useNavigate } from "react-router-dom";
import Footer from "@/components/Footer";

const Login: React.FC = () => {
  const [usuarioID, setusuarioID] = useState("");
  const [senha, setsenha] = useState("");
  const [error, setError] = useState("");
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    const success = await login(usuarioID, senha);
    if (success) {
     navigate(`/${usuarioID}/clientes`);
    } else {
      setError("Usuário ou senha incorreta!");
    }
  };

  return (
    <div className="flex flex-col min-h-screen justify-between bg-gradient-to-br from-blue-400 to-blue-600">
      <div className="flex flex-col justify-center items-center flex-grow p-6">
        {/* Container do formulário */}
        <div className="bg-white shadow-lg w-full max-w-md p-8 rounded-lg transform hover:scale-105 transition-transform duration-300">
          <h1 className="text-3xl font-semibold text-center text-blue-600 mb-6">Bem-vindo de volta!</h1>
          <form className="flex flex-col w-full space-y-6" onSubmit={handleSubmit}>
            {/* Campo de Usuário */}
            <input
              type="text"
              placeholder="Usuário"
              className="p-4 w-full rounded-md border border-gray-300 focus:outline-none focus:ring-2 focus:ring-blue-500"
              value={usuarioID}
              onChange={(e) => setusuarioID(e.target.value)}
            />
            {/* Campo de Senha */}
            <input
              type="password"
              placeholder="Senha"
              className="p-4 w-full rounded-md border border-gray-300 focus:outline-none focus:ring-2 focus:ring-blue-500"
              value={senha}
              onChange={(e) => setsenha(e.target.value)}
            />
            {/* Botão de Login */}
            <button
              type="submit"
              className="bg-blue-600 text-white py-3 rounded-md shadow-md hover:bg-blue-700 transition duration-200"
            >
              Login
            </button>
            {/* Mensagem de erro */}
            {error && (
              <div className="text-red-500 text-sm text-center mt-2">{error}</div>
            )}
          </form>
        </div>
      </div>
      {/* Footer */}
      <Footer />
    </div>
  );
};

export default Login;
