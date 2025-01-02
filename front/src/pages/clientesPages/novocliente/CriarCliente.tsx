import React, { useState } from "react";
interface NovoClienteId {
    usuarioID: number,
}
interface NovoClienteProps {
  usuarioID: NovoClienteId;
  nome: string;
  cedula: string;
  email: string;
  telefone: string;
  data_nascimento: string;
  genero: string;
  divida: string;
  codigo_postal: string;
  cidade: string;
  bairro: string;
  rua: string;
  distrito: string;
  provincia: string;
  complemento: string;
  canton: string;
  descricao: string;
}

function DadosNovoCliente() {
  
  const [formData, setFormData] = useState<NovoClienteProps>({
    usuarioID: {
      usuarioID: 1
    },
    nome: "",
    cedula: "",
    email: "",
    telefone: "",
    data_nascimento: "",
    genero: "",
    divida: "0",
    codigo_postal: "",
    cidade: "",
    bairro: "",
    rua: "",
    distrito: "",
    provincia: "",
    complemento: "",
    canton: "",
    descricao: "",
  });
  

  const [error, setError] = useState<string>("");

  const handleChange = (
    e: React.ChangeEvent<
      HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement
    >
  ) => {
    const { name, value } = e.target;


    if (name === "telefone" && !/^\d*$/.test(value)) {
      return;
    }
    

    setFormData((prevState) => ({ ...prevState, [name]: value }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
  
    for (const [key, value] of Object.entries(formData)) {
      if (!value && key !== "descricao" && key !== "complemento") {
        setError(`Por favor, preencha o campo: ${key}`);
        return;
      }
    }
  
    setError("");
  
    try {
      const response = await fetch("http://localhost:8080/cliente/insert", {
        method: "POST",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify(formData),
      });
  
      if (!response.ok) {
        throw new Error("Erro ao criar cliente");
      }
  
      const result = await response.json();
      console.log("Cliente criado com sucesso:", result);
  
      // Limpar o formulário após o envio bem-sucedido
      setFormData({
        usuarioID: {
          usuarioID: 1,
        },
        nome: "",
        cedula: "",
        email: "",
        telefone: "",
        data_nascimento: "",
        genero: "",
        divida: "0",
        codigo_postal: "",
        cidade: "",
        bairro: "",
        rua: "",
        distrito: "",
        provincia: "",
        complemento: "",
        canton: "",
        descricao: "",
      });
      
      alert("Cliente criado com sucesso!");
  
    } catch (error) {
      console.error("Erro ao criar cliente:", error);
      setError("Erro ao criar cliente. Tente novamente.");
    }
  };
  
  return (
  
    <form onSubmit={handleSubmit} className="flex flex-col p-10 gap-3">
      {[
        { label: "Nome", name: "nome", type: "text" },
        { label: "Cédula", name: "cedula", type: "text" },
        { label: "Email", name: "email", type: "email" },
        { label: "Telefone", name: "telefone", type: "text" },
        { label: "Data de Nascimento", name: "data_nascimento", type: "date" },
        { label: "Dívida", name: "divida", type: "decimal" },
        { label: "Código Postal", name: "codigo_postal", type: "text" },
        { label: "Cidade", name: "cidade", type: "text" },
        { label: "Bairro", name: "bairro", type: "text" },
        { label: "Rua", name: "rua", type: "text" },
        { label: "Distrito", name: "distrito", type: "text" },
        { label: "Província", name: "provincia", type: "text" },
        { label: "Complemento", name: "complemento", type: "text" },
        { label: "Cantón", name: "canton", type: "text" },
        { label: "Descrição", name: "descricao", type: "text" },
      ].map((field) => (
        <div key={field.name} className="relative w-full mb-4">
          <label
            htmlFor={field.name}
            className="absolute -top-3 left-5 bg-[#F5F5F5] px-2"
          >
            {field.label}
          </label>
          <input
            id={field.name}
            type={field.type}
            name={field.name}
            value={String(formData[field.name as keyof typeof formData] || "")}
            onChange={handleChange}
            className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
          />
        </div>
      ))}
       <div className="relative w-full mb-4">
        <label
          htmlFor="genero"
          className="absolute -top-3 left-5 bg-[#F5F5F5] px-2"
        >
          Gênero
        </label>
        <select
          id="genero"
          name="genero"
          value={formData.genero}
          onChange={handleChange}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        >
          <option value="" disabled>
            Selecione o gênero
          </option>
          <option value="M">Masculino</option>
          <option value="F">Feminino</option>
          <option value="Outro">Outro</option>
        </select>
      </div>
      <button type="submit" className="mt-4 p-2 bg-blue-500 text-white rounded">
        Criar Cliente
      </button>
      {error && <p className="text-red-500">{error}</p>}
    </form>
  );
}

export default DadosNovoCliente;
