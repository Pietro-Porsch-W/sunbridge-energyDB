import React, { useState, useEffect } from "react";

interface companyID {
  companyID: number;
  nome: string;
}

interface NovoUsuarioProps {
  cedula: string;
  nome: string;
  email: string;
  telefone: string;
  cidade: string;
  provincia: string;
  data_nascimento: string | null;
  rua: string;
  bairro: string;
  canton: string;
  distrito: string;
  codigo_postal: string;
  complemento: string;
  genero: string;
  departamento: string;
  data_admissao: string;
  senha: string;
  companyID: companyID | null;
}

type NovoUsuarioFormData = Omit<NovoUsuarioProps, "companyID"> & { companyID: number | null };

function DadosNovoUsuario() {
  const [formData, setFormData] = useState<NovoUsuarioFormData>({
    cedula: "",
    nome: "",
    email: "",
    telefone: "",
    cidade: "",
    provincia: "",
    data_nascimento: "",
    data_admissao: "",
    rua: "",
    bairro: "",
    canton: "",
    distrito: "",
    codigo_postal: "",
    complemento: "",
    departamento: "",
    genero: "",
    senha: "",
    companyID: null,
  });
  
  const [empresas, setEmpresas] = useState<companyID[]>([]);
  const [error, setError] = useState<string>("");

  useEffect(() => {
    const fetchEmpresas = async () => {
      try {
        const response = await fetch("http://localhost:8080/empresa/find/all");
        if (!response.ok) {
          throw new Error("Erro ao buscar empresas");
        }
        const data = await response.json();
        setEmpresas(data);
      } catch (error) {
        console.error(error);
        setError("Erro ao carregar empresas");
      }
    };

    fetchEmpresas();
  }, []);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>) => {
    const { name, value } = e.target;

    if (name === "telefone" && !/^\d*$/.test(value) || name === "codigo_postal" && !/^\d*$/.test(value)) {
      return;
    }

    if (name === "data_nascimento" && value === "") {
      setFormData((prevState) => ({ ...prevState, [name]: null }));
      return;
    }
    if (name === "genero") {
      setFormData((prevState) => ({
        ...prevState,
        genero: value === "Masculino" ? "M" : value === "Feminino" ? "F" : "",
      }));
      return;
    } 
    
    setFormData((prevState) => ({ ...prevState, [name]: value }));
  };

  const handleEmpresaChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedCompanyID = e.target.value;
  
    setFormData((prevState) => ({
      ...prevState,
      companyID: selectedCompanyID ? parseInt(selectedCompanyID) : null,
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    for (const [key, value] of Object.entries(formData)) {
      if (!value && key !== "complemento") {
        setError(`Por favor, preencha o campo: ${key}.`);
        return;
      }
    }

    setError("");


    const formattedDataNascimento =
      formData.data_nascimento && !isNaN(new Date(formData.data_nascimento).getTime())
        ? new Date(formData.data_nascimento).toISOString().split("T")[0]
        : "";
        const formattedDataAdmissao =
        formData.data_admissao && !isNaN(new Date(formData.data_admissao).getTime())
          ? new Date(formData.data_admissao).toISOString().split("T")[0]
          : "";

    const selectedEmpresa = empresas.find((empresa) => empresa.companyID === formData.companyID);

    const dataToSend = {
      cedula: formData.cedula,
      nome: formData.nome,
      email: formData.email,
      telefone: formData.telefone,
      cidade: formData.cidade,
      provincia: formData.provincia,
      data_nascimento: formattedDataNascimento,
      rua: formData.rua,
      bairro: formData.bairro,
      canton: formData.canton,
      distrito: formData.distrito,
      codigo_postal: formData.codigo_postal,
      complemento: formData.complemento,
      departamento: formData.departamento,
      genero: formData.genero,
      data_admissao: formattedDataAdmissao,
      senha: formData.senha,
      companyID: selectedEmpresa ? selectedEmpresa : null,
    };

    console.log("JSON que está sendo enviado:", JSON.stringify(dataToSend, null, 2));

    try {
      const response = await fetch("http://localhost:8080/usuario/insert", {
        method: "POST",
        headers: {
          "Content-Type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify(dataToSend),
      });

      if (!response.ok) {
        throw new Error("Falha ao enviar os dados.");
      }
      alert("Usuário registrado com sucesso!");
      
    } catch (error) {
      console.error("Erro ao enviar dados:", error);
      alert("Ocorreu um erro ao registrar o usuário.");
    }
  };

  return (
<form onSubmit={handleSubmit} className="flex flex-col w-full p-5 mb-5 gap-3">
  {[
    { label: "Cedula", name: "cedula", type: "text" },
    { label: "Nome", name: "nome", type: "text" },
    { label: "Email", name: "email", type: "email" },
    { label: "Telefone", name: "telefone", type: "text" },
    { label: "Cidade", name: "cidade", type: "text" },
    { label: "Província", name: "provincia", type: "text" },
    { label: "Data de Nascimento", name: "data_nascimento", type: "date" },
    { label: "Data de Admissão", name: "data_admissao", type: "date" },
    { label: "Rua", name: "rua", type: "text" },
    { label: "Bairro", name: "bairro", type: "text" },
    { label: "Cantón", name: "canton", type: "text" },
    { label: "Distrito", name: "distrito", type: "text" },
    { label: "Código Postal", name: "codigo_postal", type: "text" },
    { label: "Complemento", name: "complemento", type: "text" },
    { label: "Departamento", name: "departamento", type: "text" },
    { label: "Senha", name: "senha", type: "text" },
    { label: "Gênero", name: "genero", type: "select", options: ["Selecione o gênero", "Masculino", "Feminino"] }
  ].map((field) => (
    <div key={field.name} className="relative w-full mb-4">
      <label htmlFor={field.name} className="absolute -top-3 left-5 bg-[#F5F5F5] px-2">
        {field.label}
      </label>
      {field.type === "select" ? (
        <select
          id={field.name}
          name={field.name}
          value={formData[field.name as keyof NovoUsuarioFormData] || ""}
          onChange={handleChange}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        >
          {field.options?.map((option, index) => (
            <option key={option} value={index === 0 ? "" : option} disabled={index === 0}>
              {option}
            </option>
          ))}
        </select>
      ) : (
        <input
          id={field.name}
          name={field.name}
          value={formData[field.name as keyof NovoUsuarioFormData] || ""}
          onChange={handleChange}
          type={field.type}
          className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
        />
      )}
    </div>
  ))}

  <div className="relative w-full mb-4">
    <label htmlFor="empresa" className="absolute -top-3 left-5 bg-[#F5F5F5] px-2">
      Empresa
    </label>
    <select
      id="empresa"
      name="empresa"
      value={formData.companyID || ""}
      onChange={handleEmpresaChange}
      className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
    >
      <option value="" disabled>Selecione uma Empresa</option>
      {empresas.map((empresa) => (
        <option key={empresa.companyID} value={empresa.companyID}>
          {empresa.nome}
        </option>
      ))}
    </select>
  </div>

  {error && <p className="text-red-500 text-center">{error}</p>}
  <button type="submit" className="mt-5 text-white bg-blue-500 py-2 px-4 rounded">Cadastrar</button>
</form>

  );
}

export default DadosNovoUsuario;