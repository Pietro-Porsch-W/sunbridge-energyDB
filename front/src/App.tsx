  import React from 'react';
  import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
  import Cliente from './pages/clientesPages/clientes/Cliente';
  import ClienteDetalhes from './pages/clientesPages/clientesdetalhes/ClienteDetalhes';
  import Projetos from './pages/projetos/Projetos';
  import { AuthProvider } from './pages/login/AuthContext';
  import PrivateRoute from './pages/login/PrivateRoute';

  import NovoCliente from './pages/clientesPages/novocliente/NovoCliente';
  import Principal from './pages/principal/Principal';
  import EmpresaDetalhes from './pages/empresasPages/empresadetalhes/EmpresaDetalhes';
  import Empresa from './pages/empresasPages/empresa/Empresa';
  import Usuario from './pages/usuarioPages/usuario/usuario';
  import Login from './pages/login/Login';
  import PedidoDetalhes from './pages/pedidocompraPages/pedidocompraid/PedidoDetalhes';
  import PedidoCompras from './pages/pedidocompraPages/pedidocompra/PedidoCompra';
  import NovaEmpresa from './pages/empresasPages/novaempresa/NovaEmpresa';
  import NovoUsuario from './pages/usuarioPages/novousuario/NovoUsuario';
  import UsuarioDetalhes from './pages/usuarioPages/usuariodetalhes/UsuarioDetalhes';
  import NovoPedido from './pages/pedidocompraPages/novoPedido/NovoPedido';




  const App: React.FC = () => {
    return (
      <AuthProvider>
        <Router>
          <Routes>
            {/* Principal */}
            <Route path="/sunbridge-energy" element={<Principal />} />
            
            {/* Redirecionamento inicial */}
            <Route path="/" element={<Navigate to="/sunbridge-energy" replace />} />

            {/* Login */}
            <Route path="/login" element={<Login />} />

            {/* Clientes */}
            <Route path="/:usernameID/clientes" element={<PrivateRoute><Cliente /></PrivateRoute>} />
            <Route path="/:usernameID/clientes/:id" element={<PrivateRoute><ClienteDetalhes /></PrivateRoute>} />
            <Route path="/:usernameID/cliente/novo" element={<PrivateRoute><NovoCliente /></PrivateRoute>} />
            <Route path="/:usernameID/projetos" element={<PrivateRoute><Projetos /></PrivateRoute>} />

            {/* Empresas */}
            <Route path="/:usernameID/empresas" element={<PrivateRoute><Empresa /></PrivateRoute>} />
            <Route path="/:usernameID/empresas/:companyID" element={<PrivateRoute><EmpresaDetalhes /></PrivateRoute>} />
            <Route path="/:usuarioID/empresa/novo" element={<PrivateRoute><NovaEmpresa /></PrivateRoute>} />

            {/* Pedido Compra */}
            <Route path="/:usernameID/pedidocompra" element={<PrivateRoute><PedidoCompras /></PrivateRoute>} />

            <Route path="/:usernameID/pedidocompra/:ped_compra" element={<PrivateRoute><PedidoDetalhes /></PrivateRoute>} />
            <Route path="/:usernameID/pedidocompra/novo" element={<PrivateRoute>< NovoPedido/></PrivateRoute>} />
            {/* <Route path="/:usuarioID/forncedores" element={<PrivateRoute><Fornecedor /></PrivateRoute>} /> */}
            {/* Usuario */}
            <Route path="/:usernameID/usuarios" element={<PrivateRoute><Usuario /></PrivateRoute>} />
            <Route path="/:usernameID/usuarios/:id" element={<PrivateRoute><UsuarioDetalhes /></PrivateRoute>} />
            <Route path="/:usernameID/usuario/novo" element={<PrivateRoute>< NovoUsuario/></PrivateRoute>} />
          </Routes>
        </Router>
      </AuthProvider>
    );
  };

  export default App;
