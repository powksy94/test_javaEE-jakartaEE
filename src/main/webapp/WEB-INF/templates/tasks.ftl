<#import "base.ftl" as layout>

<@layout.page title="Ma liste de tâches">

    <form method="POST" action="tasks">
        <input type="text" name="title" placeholder="Nouvelle tâche" required/>
        <button type="submit">Ajouter</button>
    </form>
    <hr/>

    <#if tasks?has_content>
        <ul style="list-style:none; padding:0;">
            <#list tasks as task>
                <li class="task-item">
                    <form method="POST" action="toggle">
                        <input type="hidden" name="index" value="${task?index}"/>
                        <span class="${task.done?then('done', '')}">${task.title}</span>
                        <span style="color:#999; font-size:0.8em;">${task.createdAt}</span>
                        <button type="submit">${task.done?then('Annuler', 'Fait ✓')}</button>
                    </form>
                </li>
            </#list>
        </ul>
    <#else>
        <p>Aucune tâche pour l'instant.</p>
    </#if>

</@layout.page>

    