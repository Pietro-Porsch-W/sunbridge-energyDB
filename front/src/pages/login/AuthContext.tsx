import React, { createContext, useContext, useState, ReactNode, useEffect } from 'react';

interface AuthContextType {
  isAuthenticated: boolean;
  usuarioID: string | null;
  login: (usuarioID: string, senha: string) => Promise<boolean>;
  logout: () => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

interface AuthProviderProps {
  children: ReactNode;
}

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState<boolean>(false);
  const [usuarioID, setUsuarioID] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(true); // Estado de loading

  // Restaurar autenticação do localStorage
  useEffect(() => {
    const storedID = localStorage.getItem('usuarioID');
    if (storedID) {
      setIsAuthenticated(true);
      setUsuarioID(storedID);
    }
    setLoading(false); // Acaba a verificação de loading
  }, []);

  const login = async (usuarioID: string, senha: string): Promise<boolean> => {
    try {
      const response = await fetch('http://localhost:8080/usuario/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ usuarioID, senha }),
      });

      if (response.ok) {
        const data = await response.json();

        if (data === true) {
          setIsAuthenticated(true);
          setUsuarioID(usuarioID);

          // Salvar no localStorage
          localStorage.setItem('usuarioID', usuarioID);

          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    } catch (error) {
      console.error('Erro na requisição:', error);
      return false;
    }
  };

  const logout = () => {
    setIsAuthenticated(false);
    setUsuarioID(null);

    // Remover do localStorage
    localStorage.removeItem('usuarioID');
  };

  if (loading) {
    return <div>Carregando...</div>; // Evita renderização inconsistente durante a carga
  }

  return (
    <AuthContext.Provider value={{ isAuthenticated, usuarioID, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = (): AuthContextType => {
  const context = useContext(AuthContext);
  if (!context) throw new Error('AuthContext must be used within an AuthProvider');
  return context;
};
