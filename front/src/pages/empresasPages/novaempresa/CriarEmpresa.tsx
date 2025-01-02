import React, { useState } from "react";

interface NovoEmpresaProps {
  nome: string;
  websiteURL: string | null;
  email: string;
  telefone: string;
  cidade: string;
  provincia: string;
  data_fundacao: string;
  cedula_juridica: string;
  setor: string;
  numero_licenca: string;
  rua: string;
  bairro: string;
  canton: string;
  distrito: string;
  codigo_postal: string;
  complemento: string;
}

function DadosNovoEmpresa() {
  const [formData, setFormData] = useState<NovoEmpresaProps>({
    nome: '',
    websiteURL: ' ',
    email: '',
    telefone: '',
    cidade: '',
    provincia: '',
    data_fundacao: '',
    cedula_juridica: '',
    setor: '',
    numero_licenca: '',
    rua: '',
    bairro: '',
    canton: '',
    distrito: '',
    codigo_postal: '', // Aqui está o campo código postal
    complemento: '',
  });

  const [error, setError] = useState<string>("");

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>
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
      const response = await fetch("http://localhost:8080/empresa/insert", {
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
    } catch (error) {
      console.error("Erro ao criar cliente:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="flex flex-col p-10 gap-3">
      {[
        { label: "Nome", name: "nome", type: "text" },
        { label: "Email", name: "email", type: "email" },
        { label: "Telefone", name: "telefone", type: "text" },
        { label: "Cidade", name: "cidade", type: "text" },
        { label: "Província", name: "provincia", type: "decimal" },
        { label: "Data de Fundação", name: "data_fundacao", type: "date" },
        { label: "Cédula Jurídica", name: "cedula_juridica", type: "text" },
        { label: "Setor", name: "setor", type: "text" },
        { label: "Número Licença", name: "numero_licenca", type: "text" },
        { label: "Rua", name: "rua", type: "text" },
        { label: "Bairro", name: "bairro", type: "text" },
        { label: "Cantón", name: "canton", type: "text" },
        { label: "Distrito", name: "distrito", type: "text" },
        { label: "Código Postal", name: "codigo_postal", type: "text" },
        { label: "Complemento", name: "complemento", type: "text" },
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
            value={formData[field.name as keyof NovoEmpresaProps] ?? ''}
            onChange={handleChange}
            className="w-full h-[5vh] border-2 border-blue-500 outline-none bg-transparent pl-4"
          />
        </div>
      ))}
      <button type="submit" className="mt-4 p-2 bg-blue-500 text-white rounded">
        Criar Cliente
      </button>
      {error && <p className="text-red-500">{error}</p>}
    </form>
  );
}

export default DadosNovoEmpresa;
