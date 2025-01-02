import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

interface FornecedorPagamentoID {
  pagamento_fornecedorID: number;
  forma_pagamento: string; // Caso o backend envie uma descrição para a forma de pagamento
}

interface FornecedorID {
  fornecedorID: number;
  nome: string;
}

interface UsuarioID {
  usuarioID: number;
}

interface NovoPedidoProps {
  data_compra: string;
  data_entrega: string;
  valor: number;
  desconto: number;
  pagamento_fornecedorID: FornecedorPagamentoID | null;
  usuarioID: UsuarioID | null;
  fornecedorID: FornecedorID | null;
}

type NovoPedidoFormData = Omit<NovoPedidoProps, "pagamento_fornecedorID" | "usuarioID" | "fornecedorID"> & {
  pagamento_fornecedorID: FornecedorPagamentoID;
  usuarioID: UsuarioID;
  fornecedorID: FornecedorID;
};

function DadosNovoPedido() {
  const { usernameID } = useParams<{ usernameID: string }>(); // Obtemos o ID do usuário pela URL
  const [formData, setFormData] = useState<NovoPedidoFormData>({
    data_compra: "",
    data_entrega: "",
    valor: 0,
    desconto: 0,
    pagamento_fornecedorID: { pagamento_fornecedorID: 0, forma_pagamento: "" },
    usuarioID: { usuarioID: parseInt(usernameID || "0", 10) },
    fornecedorID: { fornecedorID: 0, nome: "" },
  });

  const [fornecedores, setFornecedores] = useState<FornecedorID[]>([]);
  const [formasPagamento, setFormasPagamento] = useState<FornecedorPagamentoID[]>([]);
  const [error, setError] = useState<string>("");

  // Requisição para obter fornecedores
  useEffect(() => {
    const fetchFornecedores = async () => {
      try {
        const response = await fetch("http://localhost:8080/fornecedor/find/all"); // Ajuste a URL da API
        if (!response.ok) throw new Error("Erro ao carregar fornecedores.");
        const data = await response.json();
        setFornecedores(data);
      } catch (error) {
        console.error(error);
        setError("Erro ao carregar fornecedores.");
      }
    };

    fetchFornecedores();
  }, []);

  // Requisição para obter formas de pagamento
  useEffect(() => {
    const fetchFormasPagamento = async () => {
      try {
        const response = await fetch("http://localhost:8080/pagamento_fornecedor/find/all"); // Ajuste a URL da API
        if (!response.ok) throw new Error("Erro ao carregar formas de pagamento.");
        const data = await response.json();
        setFormasPagamento(data);
      } catch (error) {
        console.error(error);
        setError("Erro ao carregar formas de pagamento.");
      }
    };

    fetchFormasPagamento();
  }, []);

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { name, value } = e.target;

    setFormData((prevState) => {
      if (name === "fornecedorID" || name === "pagamento_fornecedorID") {
        const updatedField =
          name === "fornecedorID"
            ? fornecedores.find((fornecedor) => fornecedor.fornecedorID === parseInt(value, 10)) || {
                fornecedorID: 0,
                nome: "",
              }
            : formasPagamento.find((forma) => forma.pagamento_fornecedorID === parseInt(value, 10)) || {
                pagamento_fornecedorID: 0,
                forma_pagamento: "",
              };

        return { ...prevState, [name]: updatedField };
      }

      return { ...prevState, [name]: value };
    });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
  
    const dataToSend = {
      data_compra: formData.data_compra,
      data_entrega: formData.data_entrega,
      valor: formData.valor,
      desconto: formData.desconto,
      pagamento_fornecedorID: {
        pagamento_fornecedorID: formData.pagamento_fornecedorID.pagamento_fornecedorID,
        forma_pagamento: formData.pagamento_fornecedorID.forma_pagamento,
      },
      usuarioID: {
        usuarioID: formData.usuarioID.usuarioID,
      },
      fornecedorID: {
        fornecedorID: formData.fornecedorID.fornecedorID,
        nome: formData.fornecedorID.nome,
      },
    };
  
    console.log("JSON enviado:", JSON.stringify(dataToSend, null, 2));
  
    try {
      const response = await fetch("http://localhost:8080/pedido_compra/insert", {
        method: "POST",
        headers: {
          "Content-Type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify(dataToSend),
      });
  
      if (!response.ok) throw new Error("Erro ao enviar dados.");
      alert("Pedido registrado com sucesso!");
    } catch (error) {
      console.error(error);
      alert("Erro ao registrar o pedido.");
    }
  };
  
  return (
    <form onSubmit={handleSubmit} className="flex flex-col w-full p-5 mb-5 gap-3">
      <div className="relative w-full mb-4">
        <label htmlFor="data_compra" className="absolute -top-3 left-5 bg-[#F5F5F5] px-2">
          Data da Compra
        </label>
        <input
          id="data_compra"
          name="data_compra"
          type="date"
          value={formData.data_compra}
          onChange={handleChange}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        />
      </div>

      <div className="relative w-full mb-4">
        <label htmlFor="data_entrega" className="absolute -top-3 left-5 bg-[#F5F5F5] px-2">
          Data de Entrega
        </label>
        <input
          id="data_entrega"
          name="data_entrega"
          type="date"
          value={formData.data_entrega}
          onChange={handleChange}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        />
      </div>

      <div className="relative w-full mb-4">
        <label htmlFor="valor" className="absolute -top-3 left-5 bg-[#F5F5F5] px-2">
          Valor
        </label>
        <input
          id="valor"
          name="valor"
          type="number"
          value={formData.valor}
          onChange={handleChange}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        />
      </div>

      <div className="relative w-full mb-4">
        <label htmlFor="desconto" className="absolute -top-3 left-5 bg-[#F5F5F5] px-2">
          Desconto
        </label>
        <input
          id="desconto"
          name="desconto"
          type="number"
          value={formData.desconto}
          onChange={handleChange}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        />
      </div>

      <div className="relative w-full mb-4">
        <label htmlFor="fornecedorID" className="absolute -top-3 left-5 bg-[#F5F5F5] px-2">
          Fornecedor
        </label>
        <select
          id="fornecedorID"
          name="fornecedorID"
          value={formData.fornecedorID.fornecedorID || ""}
          onChange={handleChange}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        >
          <option value="" disabled>Selecione um fornecedor</option>
          {fornecedores.map((fornecedor) => (
            <option key={fornecedor.fornecedorID} value={fornecedor.fornecedorID}>
              {fornecedor.nome}
            </option>
          ))}
        </select>
      </div>

      <div className="relative w-full mb-4">
        <label htmlFor="pagamento_fornecedorID" className="absolute -top-3 left-5 bg-[#F5F5F5] px-2">
          Forma de Pagamento
        </label>
        <select
          id="pagamento_fornecedorID"
          name="pagamento_fornecedorID"
          value={formData.pagamento_fornecedorID.pagamento_fornecedorID || ""}
          onChange={handleChange}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        >
          <option value="" disabled>Selecione uma forma de pagamento</option>
          {formasPagamento.map((forma) => (
            <option key={forma.pagamento_fornecedorID} value={forma.pagamento_fornecedorID}>
              {forma.forma_pagamento}
            </option>
          ))}
        </select>
      </div>

      {error && <p className="text-red-500 text-center">{error}</p>}
      <button type="submit" className="mt-5 text-white bg-blue-500 py-2 px-4 rounded">
        Cadastrar Pedido
      </button>
    </form>
  );
}

export default DadosNovoPedido;
